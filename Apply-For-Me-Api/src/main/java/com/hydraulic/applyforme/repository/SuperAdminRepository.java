package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Member;

public interface SuperAdminRepository {
    Member  getOneMember(Long id);
    Boolean removeById(Long id);
}
