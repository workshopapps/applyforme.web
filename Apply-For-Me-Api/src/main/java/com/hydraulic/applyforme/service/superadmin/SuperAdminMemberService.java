package com.hydraulic.applyforme.service.superadmin;

import com.hydraulic.applyforme.model.domain.Member;

public interface SuperAdminMemberService {
    Member getOne(Long id);
    boolean deleteMember(Long id);
}
