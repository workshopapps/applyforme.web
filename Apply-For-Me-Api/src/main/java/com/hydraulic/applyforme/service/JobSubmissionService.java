package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.response.Response;

public interface JobSubmissionService {
    Long countAllApplierSubmissions(Long Id);
    Response getAllJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir);
    Response filterJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir, String q);
}
