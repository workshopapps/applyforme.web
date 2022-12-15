package com.hydraulic.applyforme.service.impl;


import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.dto.applicant.ApplicantDto;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.applicant.ApplicantResponse;
import com.hydraulic.applyforme.model.dto.submission.SubmissionDto;
import com.hydraulic.applyforme.model.exception.ProfessionalNotFoundException;
import com.hydraulic.applyforme.model.response.ApplicantJobs;
import com.hydraulic.applyforme.model.response.ApplicantStats;
import com.hydraulic.applyforme.model.response.SubmissionResponse;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.repository.ApplicantRepository;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalJpaRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalProfileJpaRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalRepository;
import com.hydraulic.applyforme.service.ApplicantService;
import com.hydraulic.applyforme.util.ApplyForMeUtil;
import com.hydraulic.applyforme.util.CurrentUserUtil;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.hydraulic.applyforme.util.ApplyForMeUtil.createPageable;

@Service
public class ApplicantServiceImpl implements ApplicantService {


    private final JobSubmissionRepository jobSubmissionRepository;

    private final ProfessionalRepository professionalRepository;

    private final ModelMapper modelMapper;

    private final MemberRepository memberRepository;

    private final ProfessionalJpaRepository professionalJpaRepository;

    private final ProfessionalProfileJpaRepository professionalProfileJpaRepository;


    private final ApplicantRepository repository;

    public ApplicantServiceImpl(JobSubmissionRepository jobSubmissionRepository, ModelMapper modelMapper,
                                ProfessionalRepository professionalRepository,
                                MemberRepository memberRepository, ProfessionalJpaRepository professionalJpaRepository, ProfessionalProfileJpaRepository professionalProfileJpaRepository, ApplicantRepository repository) {

        this.jobSubmissionRepository = jobSubmissionRepository;
        this.professionalRepository = professionalRepository;
        this.modelMapper = modelMapper;
        this.memberRepository = memberRepository;
        this.professionalJpaRepository = professionalJpaRepository;
        this.professionalProfileJpaRepository = professionalProfileJpaRepository;
        this.repository = repository;
    }


    @Override
    public ApplyForMeResponse getApplicationList(int pageNo, int pageSize, String sortBy, String sortDir) {
        Pageable pageable =  ApplyForMeUtil.createPageable(pageNo, pageSize, sortBy, sortDir);
        var result =  jobSubmissionRepository.findAll(pageable);

        Collection<ApplicantResponse> applicantResponse = result.getContent().stream().map(x -> {
                    Random random = new Random();

                    int randomNumber = random.nextInt(400 - 200) + 200;
                    return  ApplicantResponse.builder()
                            .id(x.getId())
                            .date(x.getCreatedOn())
                            .jobLocation(x.getJobLocation())
                            .jobTitle(x.getJobTitle())
                            .jobType(x.getJobLocationType().getValue())
                            .jobCompany(x.getJobCompany())
                            .salaryRange("$" + randomNumber)
                            .build();

                }
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


    @Transactional
    @Override
    public Professional update(Long id, ApplicantDto applicantDto) {
        Professional professional = professionalRepository.findById(id).orElseThrow(() -> new ProfessionalNotFoundException("" +
                "Professional Not Found"));

        if (applicantDto.getEmailAddress() != null) {
            professional.getMember().setEmailAddress(applicantDto.getEmailAddress());
        }

        if (applicantDto.getFirstName() != null) {
            professional.getMember().setFirstName(applicantDto.getFirstName());
        }

        if (applicantDto.getLastName() != null) {
            professional.getMember().setLastName(applicantDto.getLastName());
        }

        if (applicantDto.getUsername() != null) {
            professional.getMember().setUsername(applicantDto.getUsername());
        }

        if (applicantDto.getPhoneNumber() != null) {
            professional.getMember().setPhoneNumber(applicantDto.getPhoneNumber());
        }
        return professionalRepository.save(professional);
    }

    @Override
    public Member getDetails(Long id) {
        return repository.getMyDetailsById(id);
    }

    @Override
    @Transactional
    public ApplyForMeResponse getApplicantEntries(int pageNo, int pageSize, String sortBy, String sortDir) {
        Long currentUser = CurrentUserUtil.getCurrentUser().getId();
        Member member = memberRepository.getOne(currentUser);
        Professional professional = professionalRepository.getOne(member.getId());
        Long professional_id = professional.getId();
        Page<Submission> submissions = jobSubmissionRepository.getSubmissions(professional_id, createPageable(pageNo, pageSize, sortBy, sortDir));

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

    private List<ApplicantJobs> getMemberResponse(Collection<Submission> submissions) {
        List<ApplicantJobs> responses = new ArrayList<>();

        submissions.forEach(submission -> {
            Professional professionalObj = submission.getProfessional();
            Member member = professionalObj.getMember();
            Professional professional = professionalJpaRepository.getProfessional(member.getId());

            ApplicantJobs response = ApplicantJobs.builder()
                    .id(submission.getId())
                    .professional(submission.getProfessional())
                    .applier(submission.getApplier())
                    .jobTitle(submission.getJobTitle())
                    .jobLocationType(submission.getJobLocationType())
                    .jobLink(submission.getJobLink())
                    .jobCompany(submission.getJobCompany())
                    .jobLocationType(submission.getJobLocationType())
                    .summary(submission.getSummary())
                    .otherComment(submission.getOtherComment())
                    .professionalProfile(submission.getProfessionalProfile())
                    .createdOn(submission.getCreatedOn())
                    .updatedOn(submission.getUpdatedOn())
                    .build();
            responses.add(response);
        });

        return responses;
    }

    public ApplicantStats getApplicantStats() {
        var authenticatedUser = CurrentUserUtil.getCurrentUser();
        assert authenticatedUser != null;

        Long memberId = authenticatedUser.getId();
        Professional  professional = professionalJpaRepository.getProfessional(memberId);
        Long professionalId = professional.getId();

        Long totalAppliactions = jobSubmissionRepository.countSubmissionByProfessional(professionalId);

        ApplicantStats applicantStats = new ApplicantStats();
        applicantStats.setTotalApplications(totalAppliactions);
        applicantStats.setActiveApplications(3L);
        applicantStats.setCompletedInterviews(6L);

        return applicantStats;
    }

}
