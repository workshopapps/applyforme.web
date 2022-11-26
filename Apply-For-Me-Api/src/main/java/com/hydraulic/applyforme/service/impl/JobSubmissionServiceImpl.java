package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.dto.submission.SubmissionDto;
import com.hydraulic.applyforme.model.exception.ApplierNotFoundException;
import com.hydraulic.applyforme.model.response.SubmissionEntriesResponse;
import com.hydraulic.applyforme.repository.ApplierRepository;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import com.hydraulic.applyforme.service.JobSubmissionService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.hydraulic.applyforme.util.ApplyForMeUtil.createPageable;

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
    public Long countAllApplierSubmissions(Long id) {
        Applier applier = applierRepository.getOne(id);

        if (applier == null) {
            throw new ApplierNotFoundException(id);
        }
        return repository.countByApplier(id);
    }

    @Override
    public SubmissionEntriesResponse getAllJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir) {
        Page<Submission> submission = repository.findAll(createPageable(pageNo, pageSize, sortBy, sortDir));
        return getSubmissionResponse(submission);
    }

    @Override
    public SubmissionEntriesResponse filterJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir, String q) {
        Page<Submission> submission = repository.findJobSubmissionBySearch(createPageable(pageNo, pageSize, sortBy, sortDir), q);
        return getSubmissionResponse(submission);
    }

    private SubmissionEntriesResponse getSubmissionResponse(Page<Submission> submission) {
        Collection<SubmissionDto> submissions = submission
                .getContent()
                .stream()
                .map(x -> {
                    return modelMapper.map(x, SubmissionDto.class);
                })
                .collect(Collectors.toList());

        SubmissionEntriesResponse entryResponse = new SubmissionEntriesResponse();
        entryResponse.setContent(submissions);
        entryResponse.setPageNo(submission.getNumber());
        entryResponse.setPageSize(submission.getSize());
        entryResponse.setTotalElements(submission.getTotalElements());
        entryResponse.setTotalPages(submission.getTotalPages());
        entryResponse.setLast(submission.isLast());
        return entryResponse;
    }
}
