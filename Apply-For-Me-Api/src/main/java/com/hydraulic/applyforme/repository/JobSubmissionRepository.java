package com.hydraulic.applyforme.repository;

import java.util.List;

import com.hydraulic.applyforme.model.domain.Submission;

public interface JobSubmissionRepository {

	List<Submission> getAllSubmissions(Long pID, Integer pageOffset);
}
