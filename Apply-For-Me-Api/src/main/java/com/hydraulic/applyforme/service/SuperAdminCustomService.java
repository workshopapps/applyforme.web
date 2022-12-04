package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;

public interface SuperAdminCustomService {
    ApplyForMeResponse findAll(int pageNo, int pageSize, String sortBy, String sortDir);
}
