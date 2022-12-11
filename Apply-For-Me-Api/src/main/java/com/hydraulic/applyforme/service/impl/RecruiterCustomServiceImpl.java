package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.dto.RecruiterCustomDto;
import com.hydraulic.applyforme.model.dto.submission.SubmissionDto;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.model.response.RecruiterApplicantDetails;
import com.hydraulic.applyforme.model.response.SubmissionResponse;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.repository.ProfessionalRepository;
import com.hydraulic.applyforme.repository.jpa.*;
import com.hydraulic.applyforme.service.RecruiterCustomService;
import com.hydraulic.applyforme.util.CurrentUserUtil;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.hydraulic.applyforme.util.ApplyForMeUtil.createPageable;

@Service
public class RecruiterCustomServiceImpl implements RecruiterCustomService {

    private final JobSubmissionRepository jobSubmissionRepository;
    private final MemberJpaRepository memberRepository;
    private final ProfessionalJpaRepository professionalJpaRepository;
    private final ProfessionalRepository professionalRepository;
    private final ModelMapper modelMapper;

    public RecruiterCustomServiceImpl(JobSubmissionRepository jobSubmissionRepository, MemberJpaRepository memberRepository, ProfessionalJpaRepository professionalJpaRepository, ProfessionalRepository professionalRepository, ProfessionalProfileJpaRepository professionalProfileJpaRepository, ApplierRepo applierRepo, ModelMapper modelMapper) {
        this.jobSubmissionRepository = jobSubmissionRepository;
        this.memberRepository = memberRepository;
        this.professionalJpaRepository = professionalJpaRepository;
        this.professionalRepository = professionalRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public ApplyForMeResponse getEntries(int pageNo, int pageSize, String sortBy, String sortDir) {
        Long currentUser = CurrentUserUtil.getCurrentUser().getId();
        Page<Submission> submissions = jobSubmissionRepository.getSubmissions(currentUser, createPageable(pageNo, pageSize, sortBy, sortDir));

        return getMemberResponse(submissions);
    }

    private ApplyForMeResponse getMemberResponse(Page<Submission> submissions) {
        Collection<SubmissionDto> results = submissions
                .getContent()
                .stream()
                .map(x -> {
                    return modelMapper.map(x, SubmissionDto.class);
                })
                .collect(Collectors.toList());

        ApplyForMeResponse response = new ApplyForMeResponse();
        response.setContent(getMemberResponse(submissions.getContent()));
        response.setPageNo(submissions.getNumber());
        response.setPageSize(submissions.getSize());
        response.setTotalElements(submissions.getTotalElements());
        response.setTotalPages(submissions.getTotalPages());
        response.setLast(submissions.isLast());
        return response;
    }

    private List<SubmissionResponse> getMemberResponse(Collection<Submission> submissions) {
        List<SubmissionResponse> responses = new ArrayList<>();

        submissions.forEach(submission -> {
            Professional professional = submission.getProfessional();
            Member member = professional.getMember();

            long totalApplications = jobSubmissionRepository.countSubmission();
            long appliedJobs = jobSubmissionRepository.countByApplier(CurrentUserUtil.getCurrentUser().getId());

            SubmissionResponse response = SubmissionResponse.builder()
                    .professionalId(professional.getId())
                    .memberId(member.getId())
                    .name(member.getFirstName() + " " + member.getLastName())
                    .jobTitle(submission.getJobTitle())
                    .plan("Basic")
                    .salary("$15000-$34500")
                    .jobType(submission.getJobLocation())
                    .totalApplications(totalApplications)
                    .appliedJob(appliedJobs)
                    .build();
            responses.add(response);
        });

        return responses;
    }

    @Override
    public RecruiterApplicantDetails getOne(RecruiterCustomDto recruiterCustomDto) {
        Member member = memberRepository.getOne(recruiterCustomDto.getMemberId());

        if (member == null) {
            throw new MemberNotFoundException(recruiterCustomDto.getMemberId());
        }

        Professional professional = professionalJpaRepository.getProfessional(recruiterCustomDto.getMemberId());

        RecruiterApplicantDetails response = RecruiterApplicantDetails.builder()
                .name(member.getFirstName()+" "+member.getLastName())
                .role(recruiterCustomDto.getRole())
                .joinedOn(member.getCreatedOn())
                .email(member.getEmailAddress())
                .phoneNumber(member.getPhoneNumber())
                .membershipPlan("Basic")
                .experience(3L)
                .industry("Tech")
                .salaryExpectation(recruiterCustomDto.getSalary())
                .employementType(recruiterCustomDto.getEmployement())
                .cv("Cv of " + member.getFirstName()+".pdf")
                .coverLetter("Cover letter of "+member.getFirstName()+".pdf")
                .build();

        return response;
    }
}