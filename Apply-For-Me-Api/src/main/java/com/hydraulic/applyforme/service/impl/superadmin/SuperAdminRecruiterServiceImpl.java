package com.hydraulic.applyforme.service.impl.superadmin;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.response.ApplicantForRecruiterResponse;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.jpa.ApplierJpaRepository;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import com.hydraulic.applyforme.repository.jpa.SuperAdminRecruiterJpaRepository;
import com.hydraulic.applyforme.service.superadmin.SuperAdminApplicantService;
import com.hydraulic.applyforme.service.superadmin.SuperAdminRecruiterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.hydraulic.applyforme.util.ApplyForMeUtil.createPageable;

@Service
public class SuperAdminRecruiterServiceImpl implements SuperAdminRecruiterService {

    @Autowired
    private final SuperAdminApplicantService service;

    private final SuperAdminRecruiterJpaRepository repository;

    private final SuperAdminRecruiterJpaRepository superAdminRecruiterJpaRepository;

    private final ApplierJpaRepository applierJpaRepository;

    private final JobSubmissionRepository jobSubmissionRepository;

    private final MemberRepository memberRepository;

    private final ModelMapper mapper;

    public SuperAdminRecruiterServiceImpl(SuperAdminApplicantService service, SuperAdminRecruiterJpaRepository repository, SuperAdminRecruiterJpaRepository superAdminRecruiterJpaRepository, ApplierJpaRepository applierJpaRepository, JobSubmissionRepository jobSubmissionRepository, MemberRepository memberRepository, ModelMapper mapper) {
        this.service = service;
        this.repository = repository;
        this.superAdminRecruiterJpaRepository = superAdminRecruiterJpaRepository;
        this.applierJpaRepository = applierJpaRepository;
        this.jobSubmissionRepository = jobSubmissionRepository;
        this.memberRepository = memberRepository;
        this.mapper = mapper;
    }

    @Override
    public Member searchRecruitersByName(String firstName) {
        return repository.searchRecruiterByName(firstName);
    }

    @Override
    public ApplyForMeResponse searchRecruiterById(Long member, int pageNo, int pageSize, String sortBy, String sortDir) {
        Page<Submission> submission = null;
        Member member1 = memberRepository.getOne(member);
        Applier applier = applierJpaRepository.getApplier(member1.getId());
        submission = superAdminRecruiterJpaRepository.getMember(applier.getId(), createPageable(pageNo, pageSize, sortBy, sortDir));
        return getMemberResponse(submission);
    }

    public ApplyForMeResponse getMemberResponse(Page<Submission> submissions) {

        ApplyForMeResponse response = new ApplyForMeResponse();
        response.setContent(getMemberResponse(submissions.getContent()));
        response.setPageNo(submissions.getNumber());
        response.setPageSize(submissions.getSize());
        response.setTotalElements(submissions.getTotalElements());
        response.setTotalPages(submissions.getTotalPages());
        response.setLast(submissions.isLast());
        return response;
    }

    private List<ApplicantForRecruiterResponse> getMemberResponse(Collection<Submission> submissions) {
        List<ApplicantForRecruiterResponse> responses = new ArrayList<>();

        submissions.forEach(submission -> {
            Professional professional = submission.getProfessional();
            Member member = professional.getMember();

            long applicationsDone = jobSubmissionRepository.countByProfessional(professional.getId());

            ApplicantForRecruiterResponse response = ApplicantForRecruiterResponse.builder()
                    .name(member.getFirstName() + " " + member.getLastName())
                    .mail(member.getEmailAddress())
                    .plan("Premium")
                    .applicationsDone(applicationsDone)
                    .interviews(0L)
                    .build();
            responses.add(response);
        });
        return responses;
    }
}

