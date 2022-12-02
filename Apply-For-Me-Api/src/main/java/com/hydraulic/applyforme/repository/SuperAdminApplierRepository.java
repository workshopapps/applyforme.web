package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.dto.admin.HighestApplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SuperAdminApplierRepository extends JpaRepository<Applier, Long> {
    @Query(value = "SELECT m.last_name FROM member m JOIN applier a ON (m.id = a.member_id)\n" +
            "WHERE a.id = 'q' ", nativeQuery = true)
    HighestApplier findApplierById(Long q);
}
