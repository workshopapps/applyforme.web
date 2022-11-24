package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.ApplierStatsDto;

import java.util.List;

public interface SuperAdminStatService {

    Long getTotalApplications();

    Long getTotalUsers();

    List<ApplierStatsDto> getAppliers(Integer pageOffset);


}