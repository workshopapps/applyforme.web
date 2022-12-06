package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProfessionalProfileJpaRepository extends JpaRepository<ProfessionalProfile, Long> {

    @Query("SELECT count (pp) FROM ProfessionalProfile pp where pp.professional.id = ?1")
    Long countByProfessional(Long id);
}
