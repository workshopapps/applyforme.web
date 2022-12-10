package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;

public interface ApplicantService {

    ApplyForMeResponse getApplicationList(int pageNo, int pageSize, String sortBy, String sortDir);
        Member getDetails(Long id);

}
