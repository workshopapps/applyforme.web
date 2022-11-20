package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleJpaRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByTitleAndCode(String title, String code);
}
