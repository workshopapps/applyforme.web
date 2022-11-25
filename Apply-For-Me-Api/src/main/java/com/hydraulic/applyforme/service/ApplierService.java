package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.dto.ApplierDto;
import com.hydraulic.applyforme.model.response.Response;

import java.util.List;

public interface ApplierService {
    List<ApplierDto> getAllAppliers();

    Response getApplicants(int pageNo, int pageSize, String q);
}
