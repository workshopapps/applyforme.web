package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.dto.submission.ApplierSubmissionDto;
import com.hydraulic.applyforme.model.response.SubmissionEntriesResponse;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface JobSubmissionService {
    Long countAllApplierSubmissions(Long Id);
    ApplyForMeResponse getAllJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir);
    ApplyForMeResponse filterJobSubmission(int pageNo, int pageSize, String sortBy, String sortDir, String q);
    List<ApplierSubmissionDto> getApplierSubmissionDetails(Long id);

    ApplyForMeResponse getEntries(int pageNo, int pageSize, String sortBy, String sortDir, String q, Date from, Date to);

    @Transactional(readOnly = true)
    ApplyForMeResponse getUserEntries(int pageNo, int pageSize, String sortBy, String sortDir, String q, Date from, Date to, Long userId);
    Submission findOne(Long id);
}
