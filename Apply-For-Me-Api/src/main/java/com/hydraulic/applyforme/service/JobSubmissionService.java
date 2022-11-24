package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.response.SubmissionResponse;

public interface JobSubmissionService {
    public Long countAllSubmissions(Long Id);

    SubmissionResponse getAllJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir);
}
