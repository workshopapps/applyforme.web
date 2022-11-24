package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Member;

public interface SuperAdminRepository {
    Member getOneMember(Long id);
    Boolean removeMemberById(Long id);
}
