package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.response.ApplicantDetailsResponse;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;

import java.util.Date;

public interface SuperAdminCustomService {
    ApplyForMeResponse getAll(int pageNo, int pageSize, String sortBy, String sortDir, String q, Date from, Date to);
    ApplicantDetailsResponse getOne(Long id);
}
