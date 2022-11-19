package com.hydraulic.applyforme.service;

import java.util.List;

import com.hydraulic.applyforme.model.domain.Submission;

public interface JobSubmissionService {
	
	List<Submission> getAllSubmissionsByPagination(Long pId, Integer pageOffset);

	List<Submission> getallSubmissionsSortedByField(Long pId, Integer pageOffset, String field);

    public Long countAllSubmissions(Long Id);
}
