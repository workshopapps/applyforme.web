package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.dto.submission.ApplierSubmissionDto;
import com.hydraulic.applyforme.model.dto.submission.SubmissionDto;
import com.hydraulic.applyforme.model.exception.ApplierNotFoundException;
import com.hydraulic.applyforme.model.response.SubmissionEntriesResponse;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.repository.ApplierRepository;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionJpaRepository;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import com.hydraulic.applyforme.service.JobSubmissionService;
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
public class JobSubmissionServiceImpl implements JobSubmissionService {

    private final ApplierRepository applierRepository;
    private final JobSubmissionRepository repository;
    private final com.hydraulic.applyforme.repository.JobSubmissionRepository repo;
    private final ModelMapper modelMapper;
    private final JobSubmissionJpaRepository jpaRepository;

    private final com.hydraulic.applyforme.repository.JobSubmissionRepository jobSubmissionRepository;

    public JobSubmissionServiceImpl(JobSubmissionRepository repository, ApplierRepository applierRepository, 
    		com.hydraulic.applyforme.repository.JobSubmissionRepository repo, ModelMapper modelMapper,
                                    JobSubmissionJpaRepository jpaRepository,
                                    com.hydraulic.applyforme.repository.JobSubmissionRepository jobSubmissionRepository) {
        this.applierRepository = applierRepository;
        this.repository = repository;
        this.repo = repo;
        this.modelMapper = modelMapper;
        this.jpaRepository = jpaRepository;
        this.jobSubmissionRepository = jobSubmissionRepository;
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
}
