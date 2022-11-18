package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.exception.ApplierNotFoundException;
import com.hydraulic.applyforme.repository.jpa.ApplierRepository;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import com.hydraulic.applyforme.service.JobSubmissionService;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Applier applier = applierRepository.findById(id).orElseThrow(ApplierNotFoundException::new);
        System.out.println(applier);

        List<Submission> submissions = jobSubmissionRepository.findSubmissionByApplier(applier);
        System.out.println(submissions);
        return submissions.size();
    }
}
