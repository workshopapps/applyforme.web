package com.hydraulic.applyforme.repository;

import java.util.List;

import com.hydraulic.applyforme.model.domain.Submission;

public interface JobSubmissionRepository {

	List<Submission> getAllSubmissionsByPagination(Long pID, Integer pageOffset);
	List<Submission> getallSubmissionsSortedByField(Long pId, Integer pageOffset, String field);
}
