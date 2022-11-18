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
	public List<Submission> getAllSubmissions(Long pId, Integer pageOffset) {
		
		return repository.getAll(pId, pageOffset);
	}

	
	
	
	
	
	
	
	
	
	
	
}
