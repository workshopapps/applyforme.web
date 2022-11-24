package com.hydraulic.applyforme.repository;

import java.util.List;

public interface ProfessionalRepository {

    boolean remove(Long id);

    boolean removeMany(List<Long> ids);

    boolean removeAll();
}
