package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.dto.ApplierDto;
import com.hydraulic.applyforme.model.response.SubmissionResponse;

import java.util.List;

public interface ApplierService {
    List<ApplierDto> getAllAppliers();

    SubmissionResponse getApplicants(int pageNo, int pageSize, String q);
}
