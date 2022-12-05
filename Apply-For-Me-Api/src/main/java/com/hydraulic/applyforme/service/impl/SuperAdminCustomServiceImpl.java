package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.dto.member.MemberDto;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.model.response.ApplicantDetailsResponse;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.ProfessionalRepository;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalJpaRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalProfileJpaRepository;
import com.hydraulic.applyforme.repository.jpa.SuperAdminMemberJpaRepository;
import com.hydraulic.applyforme.service.SuperAdminCustomService;
import org.modelmapper.ModelMapper;
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
public class SuperAdminCustomServiceImpl implements SuperAdminCustomService {
    private final ProfessionalRepository repository;
    private final SuperAdminMemberJpaRepository jpaRepository;
    private final MemberRepository memberRepository;
    private final ProfessionalJpaRepository professionalJpaRepository;

    private final ProfessionalProfileJpaRepository professionalProfileJpaRepository;

    private final JobSubmissionRepository jobSubmissionRepository;
    private final ModelMapper mapper;
    public SuperAdminCustomServiceImpl(ProfessionalRepository repository,
                                       SuperAdminMemberJpaRepository jpaRepository,
                                       MemberRepository memberRepository,
                                       ProfessionalJpaRepository professionalJpaRepository,
                                       ProfessionalProfileJpaRepository professionalProfileJpaRepository,
                                       JobSubmissionRepository jobSubmissionRepository,
                                       ModelMapper modelMapper, ModelMapper mapper) {
        this.repository = repository;
        this.jpaRepository = jpaRepository;
        this.memberRepository = memberRepository;
        this.professionalJpaRepository = professionalJpaRepository;
        this.professionalProfileJpaRepository = professionalProfileJpaRepository;
        this.jobSubmissionRepository = jobSubmissionRepository;
        this.mapper = mapper;
    }
    @Override
    public ApplyForMeResponse getAll(int pageNo, int pageSize, String sortBy, String sortDir, String q, Date from, Date to) {
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
    @Transactional(readOnly = true)
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

