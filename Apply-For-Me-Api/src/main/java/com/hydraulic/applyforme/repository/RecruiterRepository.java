package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Member;

public interface RecruiterRepository {
    Member getMyDetailsById(Long id);
}
