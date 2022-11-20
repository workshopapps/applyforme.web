package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Professional;

public interface ProfessionalService {

    Professional findProfessionalByMemberId(Long id);
}
