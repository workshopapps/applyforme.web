package com.hydraulic.applyforme.service;

import java.util.List;

import com.hydraulic.applyforme.model.domain.Submission;

public interface JobSubmissionService {
	
	public List<Submission> getAllSubmissionsByPagination(Long professionalId, Integer pageOffset);

    public Long countAllSubmissions(Long Id);
}
