package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Professional;

import java.util.List;

public interface ProfessionalService {

    List<Professional> findAll(Integer pageOffset);

    Professional findOne(Long id);
}
