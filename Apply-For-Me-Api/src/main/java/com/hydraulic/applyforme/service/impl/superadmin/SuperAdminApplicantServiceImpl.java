package com.hydraulic.applyforme.service.impl.superadmin;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.dto.member.MemberDto;
import com.hydraulic.applyforme.model.dto.professional.DeleteManyProfessionalDto;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.model.exception.ProfessionalNotFoundException;
import com.hydraulic.applyforme.model.response.ApplicantDetailsResponse;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.ProfessionalRepository;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalJpaRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalProfileJpaRepository;
import com.hydraulic.applyforme.repository.jpa.SuperAdminMemberJpaRepository;
import com.hydraulic.applyforme.service.superadmin.SuperAdminApplicantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.hydraulic.applyforme.util.ApplyForMeUtil.createPageable;

@Service
public class SuperAdminApplicantServiceImpl implements SuperAdminApplicantService {

    private final ProfessionalRepository repository;
    private final SuperAdminMemberJpaRepository jpaRepository;
    private final MemberRepository memberRepository;
    private final ProfessionalJpaRepository professionalJpaRepository;

    private final ProfessionalProfileJpaRepository professionalProfileJpaRepository;

    private final JobSubmissionRepository jobSubmissionRepository;

    @Autowired
    private ModelMapper mapper;

    public SuperAdminApplicantServiceImpl(ProfessionalRepository repository,
                                          SuperAdminMemberJpaRepository jpaRepository,
                                          MemberRepository memberRepository,
                                          ProfessionalJpaRepository professionalJpaRepository,
                                          JobSubmissionRepository jobSubmissionRepository,
                                          ProfessionalProfileJpaRepository professionalProfileJpaRepository) {
        this.repository = repository;
        this.jpaRepository = jpaRepository;
        this.memberRepository = memberRepository;
        this.professionalJpaRepository = professionalJpaRepository;
        this.jobSubmissionRepository = jobSubmissionRepository;
        this.professionalProfileJpaRepository = professionalProfileJpaRepository;
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        boolean removed = repository.remove(id);
        if (removed) {
            return true;
        }
        else {
            throw new ProfessionalNotFoundException(id);
        }
    }

    @Override
    @Transactional
    public boolean deleteMany(DeleteManyProfessionalDto manyDto) {
        return repository.removeMany(manyDto.getIds());
    }

    @Override
    @Transactional
    public boolean deleteAll() {
        return repository.removeAll();
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
        return getMemberResponse(members);
    }

    private ApplyForMeResponse getMemberResponse(Page<Member> members) {
        Collection<MemberDto> results = members
                .getContent()
                .stream()
                .map(x -> {
                    return mapper.map(x, MemberDto.class);
                })
                .collect(Collectors.toList());

        ApplyForMeResponse response = new ApplyForMeResponse();
        response.setContent(getMemberResponse(members.getContent()));
        response.setPageNo(members.getNumber());
        response.setPageSize(members.getSize());
        response.setTotalElements(members.getTotalElements());
        response.setTotalPages(members.getTotalPages());
        response.setLast(members.isLast());
        return response;
    }

    private List<ApplicantDetailsResponse> getMemberResponse(Collection<Member> members) {
        List<ApplicantDetailsResponse> responses = new ArrayList<>();

        members.forEach(member -> {
            Professional professional = professionalJpaRepository.getProfessional(member.getId());
            professional.setMember(null);
            professional.setSubmissions(null);
            professional.setProfessionalProfiles(null);

            long totalSubmissions = jobSubmissionRepository.countByProfessional(professional.getId());
            long totalProfiles = professionalProfileJpaRepository.countByProfessional(professional.getId());

            ApplicantDetailsResponse response = ApplicantDetailsResponse.builder()
                    .membership(member)
                    .professional(professional)
                    .totalSubmissions(totalSubmissions)
                    .totalProfessionalProfile(totalProfiles)
                    .build();
            responses.add(response);
        });

        return responses;
    }

    @Override
    public ApplicantDetailsResponse getOne(Long id) {
        Member member = memberRepository.getOne(id);

        if (member == null) {
            throw new MemberNotFoundException(id);
        }

        Professional professional = professionalJpaRepository.getProfessional(id);
        professional.setMember(null);
        professional.setSubmissions(null);
        professional.setProfessionalProfiles(null);

        long totalSubmissions = jobSubmissionRepository.countByProfessional(professional.getId());
        long totalProfiles = professionalProfileJpaRepository.countByProfessional(professional.getId());

        ApplicantDetailsResponse response = ApplicantDetailsResponse.builder()
                .membership(member)
                .professional(professional)
                .totalSubmissions(totalSubmissions)
                .totalProfessionalProfile(totalProfiles)
                .build();

        return response;
    }
}
