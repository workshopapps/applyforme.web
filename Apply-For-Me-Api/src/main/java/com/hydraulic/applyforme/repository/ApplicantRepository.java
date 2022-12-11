package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Member;

public interface ApplicantRepository {
    Member getMyDetailsById(Long id);
}
