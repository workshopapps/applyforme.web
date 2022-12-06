package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;

import java.util.Date;

public interface RecruiterCustomService {
    ApplyForMeResponse getList(int pageNo, int pageSize, String sortBy, String sortDir);
}
