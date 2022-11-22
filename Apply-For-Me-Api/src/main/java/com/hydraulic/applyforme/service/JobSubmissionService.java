package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.pojo.SubmissionResponse;

import java.util.List;

public interface JobSubmissionService {
    public Long countAllSubmissions(Long Id);

    SubmissionResponse getAllJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir);
}
