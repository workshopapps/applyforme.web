package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.dto.applicant.ApplicantResponse;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.model.response.ApplicantDetailsResponse;
import com.hydraulic.applyforme.model.response.RecruiterApplicantDetails;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalJpaRepository;
import com.hydraulic.applyforme.service.RecruiterCustomService;
import com.hydraulic.applyforme.util.ApplyForMeUtil;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class RecruiterCustomServiceImpl implements RecruiterCustomService {


    private final JobSubmissionRepository jobSubmissionRepository;
    private final MemberRepository memberRepository;
    private final ProfessionalJpaRepository professionalJpaRepository;

    private final ModelMapper modelMapper;

    public RecruiterCustomServiceImpl(JobSubmissionRepository jobSubmissionRepository, MemberRepository memberRepository, ProfessionalJpaRepository professionalJpaRepository, ModelMapper modelMapper) {
        this.jobSubmissionRepository = jobSubmissionRepository;
        this.memberRepository = memberRepository;
        this.professionalJpaRepository = professionalJpaRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ApplyForMeResponse getList(int pageNo, int pageSize, String sortBy, String sortDir) {
        Pageable pageable =  ApplyForMeUtil.createPageable(pageNo, pageSize, sortBy, sortDir);
        var result =  jobSubmissionRepository.findAll(pageable);

        Collection<ApplicantResponse> applicantResponse = result.getContent().stream().map(x -> ApplicantResponse.builder()
                .id(x.getId())
                .date(x.getCreatedOn())
                .jobLocation(x.getJobLocation())
                .jobTitle(x.getJobTitle())
                .jobType(x.getJobLocationType().getValue())
                .jobCompany(x.getJobCompany())
                .salaryRange("I don't know where to find it, I can't even do a join table")
                .build()
        ).collect(Collectors.toList());
        ApplyForMeResponse applyForMeResponse = new ApplyForMeResponse();
        applyForMeResponse.setContent(applicantResponse);
        applyForMeResponse.setPageSize(result.getSize());
        applyForMeResponse.setTotalElements(result.getTotalElements());
        applyForMeResponse.setPageNo(result.getNumber());
        applyForMeResponse.setTotalPages(result.getTotalPages());
        applyForMeResponse.setLast(result.isLast());
        return applyForMeResponse;
    }

    @Override
    public RecruiterApplicantDetails getOne(Long id, String role, String salary, String employement) {
        Member member = memberRepository.getOne(id);

        if (member == null) {
            throw new MemberNotFoundException(id);
        }

        Professional professional = professionalJpaRepository.getProfessional(id);
        professional.setMember(null);
        professional.setSubmissions(null);
        professional.setProfessionalProfiles(null);

//        long totalSubmissions = jobSubmissionRepository.countByProfessional(professional.getId());
//        long totalProfiles = professionalProfileJpaRepository.countByProfessional(professional.getId());

        RecruiterApplicantDetails response = RecruiterApplicantDetails.builder()
                .name(member.getFirstName()+" "+member.getLastName())
                .role(role)
                .joinedOn(member.getCreatedOn())
                .email(member.getEmailAddress())
                .phoneNumber(member.getPhoneNumber())
                .membershipPlan("Basic")
                .experience(3L)
                .industry("Tech")
                .salaryExpectation(salary)
                .employementType(employement)
                .cv("Cv of " + member.getFirstName()+".pdf")
                .coverLetter("Cover letter of "+member.getFirstName()+".pdf")
                .build();

        return response;
    }
}