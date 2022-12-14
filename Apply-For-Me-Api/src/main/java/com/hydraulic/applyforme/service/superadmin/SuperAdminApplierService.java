package com.hydraulic.applyforme.service.superadmin;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.admin.ApplierResponse;
import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.model.dto.member.CreateRecruiterDto;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface SuperAdminApplierService {
    ApplyForMeResponse getEntries(int pageNo, int pageSize, String sortBy, String sortDir, String q, Date from, Date to);
    Member saveRecruiter(CreateRecruiterDto dto);

    List<?> getApplier();
    public List<Member> sortAndPaginateRecruiter(int pageNo, int pageSize, String sortBy, String sortDir);
}
