package com.hydraulic.applyforme.repository;

import java.util.List;

import com.hydraulic.applyforme.model.domain.Submission;

public interface JobSubmissionRepository {

	List<Submission> getAll(Long pID, Integer pageOffset);
}
