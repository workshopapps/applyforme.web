package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Applier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplierRepository extends JpaRepository<Applier,Long> {

}
