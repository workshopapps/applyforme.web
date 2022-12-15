package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.*;
import com.hydraulic.applyforme.model.dto.submission.ApplierSubmissionDto;
import com.hydraulic.applyforme.model.dto.submission.CreateJobSubmissionDto;
import com.hydraulic.applyforme.model.dto.submission.SubmissionDto;
import com.hydraulic.applyforme.model.exception.*;
import com.hydraulic.applyforme.model.response.SubmissionEntriesResponse;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.repository.ApplierRepository;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.ProfessionalProfileRepository;
import com.hydraulic.applyforme.repository.SubmissionRepository;
import com.hydraulic.applyforme.repository.jpa.*;
import com.hydraulic.applyforme.service.JobSubmissionService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

import static com.hydraulic.applyforme.util.ApplyForMeUtil.createPageable;

@Service
public class JobSubmissionServiceImpl implements JobSubmissionService {

    private final ApplierRepository applierRepository;
    private final JobSubmissionRepository repository;
    private final com.hydraulic.applyforme.repository.JobSubmissionRepository repo;
    private final ModelMapper modelMapper;
    private final JobSubmissionJpaRepository jpaRepository;
    private final MemberJpaRepository memberJpaRepository;
    private final MemberRepository memberRepository;
    private final ApplierJpaRepository applierJpaRepository;
    private final ProfessionalJpaRepository professionalJpaRepository;
    private final SubmissionRepository submissionRepository;

    private final ProfessionalProfileRepository professionalProfileRepository;

    private final com.hydraulic.applyforme.repository.JobSubmissionRepository jobSubmissionRepository;

    public JobSubmissionServiceImpl(JobSubmissionRepository repository, ApplierRepository applierRepository, 
    		com.hydraulic.applyforme.repository.JobSubmissionRepository repo, ModelMapper modelMapper,
                                    JobSubmissionJpaRepository jpaRepository,
                                    com.hydraulic.applyforme.repository.JobSubmissionRepository jobSubmissionRepository,
                                    MemberJpaRepository memberJpaRepository,
                                    MemberRepository memberRepository,
                                    ProfessionalJpaRepository professionalJpaRepository,
                                    ApplierJpaRepository applierJpaRepository,
                                    ProfessionalProfileRepository professionalProfileRepository,
                                    SubmissionRepository submissionRepository) {
        this.applierRepository = applierRepository;
        this.repository = repository;
        this.repo = repo;
        this.modelMapper = modelMapper;
        this.jpaRepository = jpaRepository;
        this.jobSubmissionRepository = jobSubmissionRepository;
        this.memberJpaRepository = memberJpaRepository;
        this.memberRepository = memberRepository;
        this.professionalJpaRepository = professionalJpaRepository;
        this.applierJpaRepository = applierJpaRepository;
        this.professionalProfileRepository = professionalProfileRepository;
        this.submissionRepository = submissionRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Long countAllApplierSubmissions(Long id) {
        Applier applier = applierRepository.getOne(id);

        if (applier == null) {
            throw new ApplierNotFoundException(id);
        }
        return repository.countByApplier(id);
    }


    @Override
    @Transactional(readOnly = true)
    public ApplyForMeResponse getAllJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir) {
        Page<Submission> submission = repository.findAll(createPageable(pageNo, pageSize, sortBy, sortDir));
        return getSubmissionResponse(submission);
    }

    @Override
    public ApplyForMeResponse filterJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir, String q) {
        Page<Submission> submission = repository.findJobSubmissionBySearch(createPageable(pageNo, pageSize, sortBy, sortDir), q);
        return getSubmissionResponse(submission);
    }

    private ApplyForMeResponse getSubmissionResponse(Page<Submission> submission) {
        Collection<SubmissionDto> submissions = submission
                .getContent()
                .stream()
                .map(x -> {
                    return modelMapper.map(x, SubmissionDto.class);
                })
                .collect(Collectors.toList());

        SubmissionEntriesResponse response = new SubmissionEntriesResponse();
        response.setPageNo(submission.getNumber());
        response.setContent(submissions);
        response.setPageSize(submission.getSize());
        response.setTotalElements(submission.getTotalElements());
        response.setTotalPages(submission.getTotalPages());
        response.setLast(submission.isLast());
        return response;
    }

    public List<ApplierSubmissionDto> getApplierSubmissionDetails(Long id) {
        List<ApplierSubmissionDto> applierSubmissionDtos = repo.getSubmissionDetails(id);
        return applierSubmissionDtos;
    }

    @Override
    @Transactional(readOnly = true)
    public ApplyForMeResponse getEntries(int pageNo, int pageSize, String sortBy, String sortDir, String q, Date from, Date to) {
        Page<Submission> submissions = null;

        if (from != null && to != null && q != null && q.trim() != "") {
            submissions = jpaRepository.getEntries(from, to, q, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        else if (from != null && to != null) {
            submissions = jpaRepository.getEntries(from, to, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        if (q != null && q.trim() != "") {
            submissions = jpaRepository.getEntries(q, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        else {
            submissions = jpaRepository.getEntries(createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        return getJobSubmissionResponse(submissions);
    }

    @Override
    @Transactional(readOnly = true)
    public ApplyForMeResponse getUserEntries(int pageNo, int pageSize, String sortBy, String sortDir, String q, Date from, Date to, Long userId) {
        Page<Submission> submissions = null;

        if (from != null && to != null && q != null && q.trim() != "") {
            submissions = jpaRepository.getUserEntries(from, to, q, userId, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        else if (from != null && to != null) {
            submissions = jpaRepository.getUserEntries(from, to, userId, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        if (q != null && q.trim() != "") {
            submissions = jpaRepository.getUserEntries(q, userId, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        else {
            submissions = jpaRepository.getUserEntries(userId, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        return getJobSubmissionResponse(submissions);
    }

    @Override
    public Submission findOne(Long id) {
        Submission submission = jobSubmissionRepository.getOne(id);
        submission.getProfessional().setSubmissions(null);
        submission.getApplier().setSubmissions(null);
        submission.getProfessional().getMember().setRoles(null);
        submission.getProfessional().setProfessionalProfiles(null);
        return submission;
    }

    @Override
    public Submission findOne(Long memberId, Long id) {
        Submission submission = jpaRepository.getOneUserSubmission(memberId, id);
        submission.getProfessional().setSubmissions(null);
        submission.getApplier().setSubmissions(null);
        submission.getProfessional().getMember().setRoles(null);
        submission.getProfessional().setProfessionalProfiles(null);
        return submission;
    }

    private ApplyForMeResponse getJobSubmissionResponse(Page<Submission> submissions) {
        Collection<Submission> results = submissions
                .getContent()
                .stream()
                .map(x -> {
                    x.getProfessional().setSubmissions(null);
                    x.getProfessional().getMember().setRoles(null);
                    x.getProfessional().setProfessionalProfiles(null);
                    x.getApplier().setSubmissions(null);
                    x.getApplier().getMember().setRoles(null);
                    return modelMapper.map(x, Submission.class);
                })
                .collect(Collectors.toList());

        ApplyForMeResponse response = new ApplyForMeResponse();
        response.setContent(results);
        response.setPageNo(submissions.getNumber());
        response.setPageSize(submissions.getSize());
        response.setTotalElements(submissions.getTotalElements());
        response.setTotalPages(submissions.getTotalPages());
        response.setLast(submissions.isLast());
        return response;
    }

    @Override
    @Transactional
    public Submission saveSubmission(CreateJobSubmissionDto dto) {
        Professional existingProfessional = professionalJpaRepository.getProfessional(dto.getProfessionalId());
        if (existingProfessional == null) {
            throw new ProfessionalNotFoundException(dto.getProfessionalId());
        }

        Applier existingApplier = applierJpaRepository.getApplier(dto.getApplierId());
        if (existingApplier == null) {
            throw new ApplierNotFoundException(dto.getApplierId());
        }

        ProfessionalProfile existingProfessionalProfile = professionalProfileRepository.getOne(dto.getProfessionalProfileId());
        if (existingProfessionalProfile == null) {
            throw new ProfessionalProfileNotFoundException(dto.getProfessionalProfileId());
        }

        Submission submission = new Submission();
        submission.setJobTitle(dto.getJobTitle());
        submission.setJobCompany(dto.getJobCompany());
        submission.setJobLink(dto.getJobLink());
        submission.setJobLocation(dto.getJobLocation());
        submission.setOtherComment(dto.getOtherComment());
        submission.setSummary(dto.getSummary());
        submission.setProfessional(existingProfessional);
        submission.setProfessionalProfile(existingProfessionalProfile);
        submission.setApplier(existingApplier);
        submissionRepository.saveOne(submission);

        submission.getProfessional().setSubmissions(null);
        submission.getApplier().setSubmissions(null);
        submission.getProfessional().setProfessionalProfiles(null);
        return submission;
    }

}
