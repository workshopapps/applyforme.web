package com.hydraulic.applyforme.service;

import java.util.List;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.dto.ProfessionalJobSubmissionDTO;
import com.hydraulic.applyforme.model.pojo.SubmissionResponse;

public interface JobSubmissionService {
	
	public ProfessionalJobSubmissionDTO getAllSubmissionsByPagination(Long professionalId, Integer pageOffset);

    public Long countAllSubmissions(Long Id);

    SubmissionResponse getAllJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir);

    SubmissionResponse filterJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir, String q);
}
