package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Professional;

import java.util.List;

public interface ProfessionalRepository {
    List<Professional> getAll();

    List<Professional> getAll(Integer pageOffset);

    Professional getOne(Long id);

    Professional saveOne(Professional body);

    Professional updateOne(Professional body);

    boolean remove(Long id);

    boolean removeMany(List<Long> ids);

    boolean removeAll();

}
