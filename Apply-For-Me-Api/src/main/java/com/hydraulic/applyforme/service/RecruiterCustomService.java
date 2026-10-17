package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.response.RecruiterApplicantDetails;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;

public interface RecruiterCustomService {
    RecruiterApplicantDetails getOne(Long memberid, String role, String salary, String employement);
    ApplyForMeResponse getEntries(int pageNo, int pageSize, String sortBy, String sortDir);
}
