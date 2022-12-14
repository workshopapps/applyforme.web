package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ApplierJpaRepository extends JpaRepository<Applier, Long> {

    @Query("select ap from Applier ap where ap.member.id = :id")
    Applier getApplier(@Param("id") Long memberId);
}
