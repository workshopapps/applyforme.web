package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Professional;

public interface ProfessionalRepository {
    Professional getProfessionalByMemberId(Long id);
}
