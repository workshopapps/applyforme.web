package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.dto.RecruiterCustomDto;
import com.hydraulic.applyforme.model.response.RecruiterApplicantDetails;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;

import java.util.Date;

public interface RecruiterCustomService {
    RecruiterApplicantDetails getOne(RecruiterCustomDto recruiterCustomDto);
    ApplyForMeResponse getEntries(int pageNo, int pageSize, String sortBy, String sortDir);
}
