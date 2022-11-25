package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.dto.submission.SubmissionDto;
import com.hydraulic.applyforme.model.exception.ApplierNotFoundException;
import com.hydraulic.applyforme.model.pojo.SubmissionResponse;
import com.hydraulic.applyforme.repository.ApplierRepository;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import com.hydraulic.applyforme.service.JobSubmissionService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobSubmissionServiceImpl implements JobSubmissionService {

    private final ApplierRepository applierRepository;
    private final JobSubmissionRepository repository;

    private final ModelMapper modelMapper;

    public JobSubmissionServiceImpl(JobSubmissionRepository repository, ApplierRepository applierRepository, ModelMapper modelMapper) {
        this.applierRepository = applierRepository;
        this.repository = repository;
        this.modelMapper = modelMapper;
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

        Page<Submission> submission = repository.findAll(pageable);

        return getSubmissionResponse(submission);
    }

    @Override
    public SubmissionResponse filterJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir, String q) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Submission> submission = repository.findJobSubmissionBySearch(pageable, q);

        return getSubmissionResponse(submission);
    }

    private SubmissionResponse getSubmissionResponse(Page<Submission> submission) {
        Collection<SubmissionDto> submissions = submission.getContent().stream().map(x ->
                modelMapper.map(x, SubmissionDto.class)).collect(Collectors.toList());
        SubmissionResponse submissionResponse = new SubmissionResponse();
        submissionResponse.setContent(submissions);
        submissionResponse.setPageNo(submission.getNumber());
        submissionResponse.setPageSize(submission.getSize());
        submissionResponse.setTotalElements(submission.getTotalElements());
        submissionResponse.setTotalPages(submission.getTotalPages());
        submissionResponse.setLast(submission.isLast());
        return submissionResponse;
    }
}
