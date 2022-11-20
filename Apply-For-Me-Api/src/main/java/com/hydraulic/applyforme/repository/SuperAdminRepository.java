package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Member;

public interface SuperAdminRepository {
    Member getOne(Long id);
}
