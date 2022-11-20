package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SuperAdminJpaRepository extends JpaRepository<Member, Long> {
}
