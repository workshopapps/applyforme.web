package com.hydraulic.applyforme.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.repository.JobSubmissionRepository;
import com.hydraulic.applyforme.service.JobSubmissionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JobSubmissionServiceImpl implements JobSubmissionService{
	
	private final JobSubmissionRepository repository;
	
	public JobSubmissionServiceImpl(JobSubmissionRepository jobSubmissionRepository) {
		this.repository = jobSubmissionRepository;
	}

	@Override
	public List<Submission> getAllSubmissionsByPagination(Long pId, Integer pageOffset) {
				
		return repository.getAllSubmissionsByPagination(pId, pageOffset);
	}

	@Override
	public List<Submission> getallSubmissionsSortedByField(Long pId, Integer pageOffset, String field) {
		
		return repository.getallSubmissionsSortedByField(pId, pageOffset, field);
	}
	
	
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
