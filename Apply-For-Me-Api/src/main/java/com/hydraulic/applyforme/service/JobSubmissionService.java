package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.dto.submission.SubmissionDto;
import com.hydraulic.applyforme.model.pojo.SubmissionResponse;

public interface JobSubmissionService {
    public Long countAllSubmissions(Long Id);

    SubmissionResponse getAllJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir);

    SubmissionResponse filterJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir, String q);

    SubmissionDto getSubmissionDetails(Long  professionalId, Long submissionId);
}
