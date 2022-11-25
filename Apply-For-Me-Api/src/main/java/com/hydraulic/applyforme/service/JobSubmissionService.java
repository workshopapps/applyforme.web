package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.dto.submission.SubmissionDto;
import com.hydraulic.applyforme.model.response.SubmissionResponse;

public interface JobSubmissionService {
    Long countAllApplierSubmissions(Long Id);
    SubmissionResponse getAllJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir);
    SubmissionResponse filterJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir, String q);

    SubmissionDto getSubmissionDetails(Long  professionalId, Long submissionId);
}
