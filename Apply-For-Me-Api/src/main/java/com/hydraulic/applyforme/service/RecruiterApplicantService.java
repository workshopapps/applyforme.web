package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.response.ApplicantDetailsResponse;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;

import java.util.Date;

public interface RecruiterApplicantService {
    ApplyForMeResponse getEntries(int pageNo, int pageSize, String sortBy, String sortDir, String q, Date from, Date to);
    ApplicantDetailsResponse getOne(Long id);

    Member getOneMember(Long id);
}
