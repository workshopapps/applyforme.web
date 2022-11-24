package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionalJpaRepository extends JpaRepository<Professional, Long> {
}
