package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Submission;

import com.hydraulic.applyforme.model.dto.pojo.SubmissionResponse;

import com.hydraulic.applyforme.model.exception.ApplierNotFoundException;

import com.hydraulic.applyforme.repository.ApplierRepository;
import com.hydraulic.applyforme.repository.ApplyForMeRepository;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import com.hydraulic.applyforme.service.JobSubmissionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobSubmissionServiceImpl implements JobSubmissionService {

    private final ApplierRepository applierRepository;
    private final JobSubmissionRepository repository;


    public JobSubmissionServiceImpl(JobSubmissionRepository repository, ApplierRepository applierRepository) {
        this.applierRepository = applierRepository;
        this.repository = repository;
    }


    @Override
    public Long countAllSubmissions(Long id) {
        Optional<Applier> applier = Optional.ofNullable(applierRepository.getOne(id));

        if (applier.isEmpty()) {
            throw new ApplierNotFoundException(id);
        }

        if (applier.isPresent()) {
            return repository.countByApplier(id);
        }
        return 0L;
    }
    @Override
    public SubmissionResponse getAllJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Submission> submission = jobSubmissionRepository.findAll(pageable);
        Collection<Submission> submissions = submission.getContent();
        SubmissionResponse submissionResponse = new SubmissionResponse();
        submissionResponse.setContent(submissions);
        submissionResponse.setPageNo(submission.getNumber());
        submissionResponse.setPageSize(submission.getSize());
        submissionResponse.setTotalElements(submission.getTotalElements());
        submissionResponse.setTotalPages(submission.getTotalPages());
        submissionResponse.setLast(submission.isLast());
        return submissionResponse;
    }

    @Override
    public Optional<List<Submission>> getSubmissionsBySearch(String query) {
        return jobSubmissionRepository.findJobSubmissionBySearch(query);
    }
}
