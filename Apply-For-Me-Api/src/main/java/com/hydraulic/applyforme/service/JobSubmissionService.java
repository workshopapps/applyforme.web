package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.dto.submission.ApplierSubmissionDto;
import com.hydraulic.applyforme.model.response.SubmissionEntriesResponse;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;

import java.util.List;

public interface JobSubmissionService {
    Long countAllProfessionalSubmissions(Long id);
    Long countAllApplierSubmissions(Long Id);
    ApplyForMeResponse getAllJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir);
    ApplyForMeResponse filterJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir, String q);
    List<ApplierSubmissionDto> getApplierSubmissionDetails(Long id);
}
