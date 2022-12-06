package com.hydraulic.applyforme.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hydraulic.applyforme.model.domain.Professional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfessionalJpaRepository extends JpaRepository<Professional, Long> {

    @Query("select p from Professional p where p.member.id = :id")
    Professional getProfessional(@Param("id") Long memberId);
}
