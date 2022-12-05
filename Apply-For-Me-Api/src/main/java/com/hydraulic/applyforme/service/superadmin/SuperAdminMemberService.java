package com.hydraulic.applyforme.service.superadmin;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;

import java.util.List;

public interface SuperAdminMemberService {
    Member getOne(Long id);
    boolean deleteMember(Long id);
    ApplyForMeResponse viewAllRecruiters(int pageNo, int pageSize, String sortBy, String sortDir);
}
