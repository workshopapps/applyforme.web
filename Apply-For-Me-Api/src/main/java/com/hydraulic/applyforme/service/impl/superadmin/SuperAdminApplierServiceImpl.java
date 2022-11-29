package com.hydraulic.applyforme.service.impl.superadmin;

import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.model.dto.member.MemberDto;
import com.hydraulic.applyforme.model.dto.member.RecruiterCreateDto;
import com.hydraulic.applyforme.model.enums.RoleType;
import com.hydraulic.applyforme.model.exception.EmailAlreadyExistsException;
import com.hydraulic.applyforme.model.exception.RoleNotFoundException;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.SuperAdminApplierJpaRepository;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.repository.jpa.RoleJpaRepository;
import com.hydraulic.applyforme.service.superadmin.SuperAdminApplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.hydraulic.applyforme.util.ApplyForMeUtil.createPageable;

@Service
public class SuperAdminApplierServiceImpl implements SuperAdminApplierService {

    private final SuperAdminApplierJpaRepository jpaRepository;
    private final RoleJpaRepository roleJpaRepository;
    private final MemberRepository memberRepository;
    private final MemberJpaRepository memberJpaRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public SuperAdminApplierServiceImpl(SuperAdminApplierJpaRepository jpaRepository, RoleJpaRepository roleJpaRepository,
                                        MemberRepository memberRepository, MemberJpaRepository memberJpaRepository) {
        this.jpaRepository = jpaRepository;
        this.roleJpaRepository = roleJpaRepository;
        this.memberRepository = memberRepository;
        this.memberJpaRepository = memberJpaRepository;
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
    public Member saveRecruiter(RecruiterCreateDto dto) {
        boolean existingMember = memberJpaRepository.existsByEmailAddress(dto.getEmailAddress());
        if (existingMember) {
            throw new EmailAlreadyExistsException();
        }

        Optional<Role> existingRole = roleJpaRepository.findByCode(RoleType.RECRUITER.getValue());
        if (existingRole.isEmpty()) {
            throw new RoleNotFoundException(RoleType.RECRUITER.getValue());
        }

        Member member = mapper.map(dto, Member.class);
        member.setPassword(dto.getPassword());
        member.getRoles().add(existingRole.get());
        member.setNationality(Country.builder().id(dto.getNationality()).build());
        member.setNationality(Country.builder().id(dto.getCountryOfResidence()).build());
        return memberRepository.saveOne(member);
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
}
