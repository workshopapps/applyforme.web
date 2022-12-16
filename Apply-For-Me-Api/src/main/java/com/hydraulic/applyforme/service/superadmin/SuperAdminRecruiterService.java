package com.hydraulic.applyforme.service.superadmin;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.response.ApplicantForRecruiterResponse;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;

public interface SuperAdminRecruiterService {
    Member searchRecruitersByName(String firstName);
    ApplyForMeResponse searchRecruiterById(Long member, int pageNo, int pageSize, String sortBy, String sortDir);
}
