package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Professional;

import java.util.List;

public interface ProfessionalRepository {

    List<Professional> getAll(Integer pageOffset);

    Professional getOne(Long id);
}
