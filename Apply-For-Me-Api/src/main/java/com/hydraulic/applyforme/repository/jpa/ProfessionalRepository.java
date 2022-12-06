package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.dto.professional.ProfessionalDto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hydraulic.applyforme.model.domain.Professional;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
}
