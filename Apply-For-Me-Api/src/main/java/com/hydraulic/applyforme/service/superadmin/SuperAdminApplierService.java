package com.hydraulic.applyforme.service.superadmin;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.admin.ApplierResponse;
import com.hydraulic.applyforme.model.dto.member.CreateRecruiterDto;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;

import java.util.Date;
import java.util.List;

public interface SuperAdminApplierService {
    ApplyForMeResponse getEntries(int pageNo, int pageSize, String sortBy, String sortDir, String q, Date from, Date to);
    Member saveRecruiter(CreateRecruiterDto dto);

    List<?> getApplier();
}
