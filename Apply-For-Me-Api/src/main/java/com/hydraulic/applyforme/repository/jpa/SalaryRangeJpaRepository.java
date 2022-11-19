package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.model.domain.SalaryRange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalaryRangeJpaRepository extends JpaRepository<SalaryRange, Long> {

    Optional<SalaryRange> findBySalaryRange(String salaryRange);
}
