package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.repository.ApplierRepository;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import com.hydraulic.applyforme.service.JobSubmissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSubmissionServiceImpl implements JobSubmissionService {

    private final ApplierRepository applierRepository;
    private final JobSubmissionRepository jobSubmissionRepository;

    public JobSubmissionServiceImpl(ApplierRepository applierRepository, JobSubmissionRepository jobSubmissionRepository) {
        this.applierRepository = applierRepository;
        this.jobSubmissionRepository = jobSubmissionRepository;
    }

    @Override
    public Integer countAllSubmissions(Long id) {
        Optional<Applier> applier = Optional.ofNullable(applierRepository.getOne(id));
        if(applier.isPresent())
        {
        List<Submission> submissions = jobSubmissionRepository.findSubmissionByApplier(applier.get());
        return submissions.size();
        }
        return 0;

    }
}
