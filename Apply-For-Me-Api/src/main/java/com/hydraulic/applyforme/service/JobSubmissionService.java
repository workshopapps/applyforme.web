package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.response.SubmissionEntriesResponse;

public interface JobSubmissionService {
    Long countAllApplierSubmissions(Long Id);
    SubmissionEntriesResponse getAllJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir);
    SubmissionEntriesResponse filterJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir, String q);
}
