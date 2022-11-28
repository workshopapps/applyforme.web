package com.hydraulic.applyforme.service.superadmin;

import com.hydraulic.applyforme.model.response.ApplierEntriesResponse;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;

import java.util.Date;

public interface SuperAdminApplierService {

    ApplyForMeResponse getEntries(int pageNo, int pageSize, String sortBy, String sortDir, String q, Date from, Date to);
}
