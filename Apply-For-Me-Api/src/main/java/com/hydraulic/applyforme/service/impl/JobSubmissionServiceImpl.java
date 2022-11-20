package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.exception.ApplierNotFoundException;
import com.hydraulic.applyforme.repository.ApplierRepository;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import com.hydraulic.applyforme.service.JobSubmissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
}
