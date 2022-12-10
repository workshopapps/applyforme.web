package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Applier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplierRepo extends JpaRepository<Applier, Long> {

    Applier findApplierByMemberEmailAddress(String email);

}
