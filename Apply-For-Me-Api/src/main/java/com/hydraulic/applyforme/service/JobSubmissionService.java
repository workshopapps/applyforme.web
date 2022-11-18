package com.hydraulic.applyforme.service;

import java.util.List;

import com.hydraulic.applyforme.model.domain.Submission;

public interface JobSubmissionService {

	List<Submission> getAllSubmissions(Long pId, Integer pageOffset);
}
