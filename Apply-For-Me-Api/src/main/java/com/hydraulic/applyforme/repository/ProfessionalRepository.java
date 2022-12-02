package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Professional;

import java.util.List;

public interface ProfessionalRepository {

    Professional getOne(Long id);
    List<Professional> getAll(Integer pageOffset);

    Professional getRef(Long id);

    boolean remove(Long id);

    boolean removeMany(List<Long> ids);

    boolean removeAll();
}
