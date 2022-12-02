package com.hydraulic.applyforme.service.impl.superadmin;

import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.model.dto.admin.ApplierResponse;
import com.hydraulic.applyforme.model.dto.admin.HighestApplier;
import com.hydraulic.applyforme.model.dto.member.MemberDto;
import com.hydraulic.applyforme.model.dto.member.CreateRecruiterDto;
import com.hydraulic.applyforme.model.enums.RoleType;
import com.hydraulic.applyforme.model.exception.CountryNotFoundException;
import com.hydraulic.applyforme.model.exception.EmailAlreadyExistsException;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.model.exception.RoleNotFoundException;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.repository.CountryRepository;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.SuperAdminApplierJpaRepository;
import com.hydraulic.applyforme.repository.SuperAdminApplierRepository;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.repository.jpa.RoleJpaRepository;
import com.hydraulic.applyforme.service.superadmin.SuperAdminApplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

import static com.hydraulic.applyforme.util.ApplyForMeUtil.createPageable;

@Service
public class SuperAdminApplierServiceImpl implements SuperAdminApplierService {

    private final SuperAdminApplierJpaRepository jpaRepository;

    private final SuperAdminApplierRepository superAdminApplierRepository;
    private final RoleJpaRepository roleJpaRepository;

    private final JobSubmissionRepository jobSubmissionRepository;
    private final MemberRepository memberRepository;
    private final MemberJpaRepository memberJpaRepository;

    private final CountryRepository countryRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public SuperAdminApplierServiceImpl(SuperAdminApplierJpaRepository jpaRepository,
                                        SuperAdminApplierRepository superAdminApplierRepository, RoleJpaRepository roleJpaRepository,
                                        JobSubmissionRepository jobSubmissionRepository, MemberRepository memberRepository,
                                        MemberJpaRepository memberJpaRepository,
                                        CountryRepository countryRepository) {
        this.jpaRepository = jpaRepository;
        this.superAdminApplierRepository = superAdminApplierRepository;
        this.roleJpaRepository = roleJpaRepository;
        this.jobSubmissionRepository = jobSubmissionRepository;
        this.memberRepository = memberRepository;
        this.memberJpaRepository = memberJpaRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public ApplyForMeResponse getEntries(int pageNo, int pageSize, String sortBy, String sortDir, String q, Date from, Date to) {
        Page<Member> members = null;

        if (from != null && to != null && q != null && q.trim() != "") {
            members = jpaRepository.getEntries(from, to, q, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        else if (from != null && to != null) {
            members = jpaRepository.getEntries(from, to, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        if (q != null && q.trim() != "") {
            members = jpaRepository.getEntries(q, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        else {
            members = jpaRepository.getEntries(createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        return getApplierResponse(members);
    }

    @Override
    @Transactional
    public Member saveRecruiter(CreateRecruiterDto dto) {
        boolean existingMember = memberJpaRepository.existsByEmailAddress(dto.getEmailAddress());
        if (existingMember) {
            throw new EmailAlreadyExistsException();
        }

        Optional<Role> existingRole = roleJpaRepository.findByCode(RoleType.RECRUITER.getValue());
        if (existingRole.isEmpty()) {
            throw new RoleNotFoundException(RoleType.RECRUITER.getValue());
        }

        Country nationality = countryRepository.getOne(dto.getNationality());
        if (nationality == null) {
            throw new CountryNotFoundException(dto.getNationality());
        }

        Country countryOfResidence = countryRepository.getOne(dto.getCountryOfResidence());
        if (countryOfResidence == null) {
            throw new CountryNotFoundException(dto.getCountryOfResidence());
        }

        Member member = mapper.map(dto, Member.class);
        member.setPassword(dto.getPassword());
        member.getRoles().add(existingRole.get());
        member.setNationality(nationality);
        member.setCountryOfResidence(countryOfResidence);
        return memberRepository.saveOne(member);
    }

    @Override
    public List<?> getApplier() {
        List<ApplierResponse> applierResponses =  jobSubmissionRepository.getHighestApplier();
        List<ApplierResponse> responses = new ArrayList<>();
        responses.add(applierResponses.get(0));
        for (int i = 1; i < applierResponses.size(); i++) {
            if (applierResponses.get(i).getValueOccurrence() >= applierResponses.get(0).getValueOccurrence() ) {
                responses.add(applierResponses.get(i));
            }
        }

       return responses.stream().map(x -> superAdminApplierRepository.findById(x.getApplierId())).map(x
        -> HighestApplier.builder()
                .id(x.get().getId())
                .member(x.get().getMember())
                .build()).collect(Collectors.toList());
    }

    private ApplyForMeResponse getApplierResponse(Page<Member> members) {
        Collection<MemberDto> results = members
                .getContent()
                .stream()
                .map(x -> {
                    return mapper.map(x, MemberDto.class);
                })
                .collect(Collectors.toList());

        ApplyForMeResponse response = new ApplyForMeResponse();
        response.setContent(results);
        response.setPageNo(members.getNumber());
        response.setPageSize(members.getSize());
        response.setTotalElements(members.getTotalElements());
        response.setTotalPages(members.getTotalPages());
        response.setLast(members.isLast());
        return response;
    }

    @Override
    public List<Member> sortAndPaginateRecruiter( int pageNo, int pageSize, String sortBy, String sortDir) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Optional<Role> existingRole = roleJpaRepository.findByCode(RoleType.RECRUITER.getValue());
        Page<Member> allAdminPagedContent = jpaRepository.findMembersByRoles(paging, existingRole);
        if (allAdminPagedContent.hasContent()) {
            return allAdminPagedContent.getContent();
        } else {
            throw new MemberNotFoundException(existingRole.get().getId());
        }
    }
}
