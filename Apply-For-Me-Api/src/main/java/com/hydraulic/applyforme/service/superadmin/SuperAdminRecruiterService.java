package com.hydraulic.applyforme.service.superadmin;

import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;

public interface SuperAdminRecruiterService {
    ApplyForMeResponse searchRecruitersByName(int pageNo, int pageSize, String sortBy, String sortDir, String q);
}
