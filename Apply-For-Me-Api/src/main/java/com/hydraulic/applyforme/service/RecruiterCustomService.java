package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.response.RecruiterApplicantDetails;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;

import java.util.Date;

public interface RecruiterCustomService {
    ApplyForMeResponse getList(int pageNo, int pageSize, String sortBy, String sortDir);
    RecruiterApplicantDetails getOne(Long id, String role, String salary, String employement);
}
