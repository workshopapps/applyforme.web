package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.response.SubmissionEntriesResponse;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;

public interface JobSubmissionService {
    Long countAllApplierSubmissions(Long Id);
    ApplyForMeResponse getAllJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir);
    ApplyForMeResponse filterJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir, String q);
}
