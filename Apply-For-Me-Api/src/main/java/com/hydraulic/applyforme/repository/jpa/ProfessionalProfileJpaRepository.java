package com.hydraulic.applyforme.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hydraulic.applyforme.model.domain.ProfessionalProfile;

public interface ProfessionalProfileJpaRepository extends JpaRepository<ProfessionalProfile, Long> {

    @Query("SELECT count (pp) FROM ProfessionalProfile pp where pp.professional.id = ?1")
    Long countByProfessional(Long id);
    
    @Query("select pp from ProfessionalProfile pp where pp.professional.member.id = :id")
    List<ProfessionalProfile> getJobProfiles(@Param("id") Long member_id);
}
