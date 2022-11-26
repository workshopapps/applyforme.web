package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.password.ChangePasswordDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordJpaRepository extends JpaRepository<Member, String> {

    Optional<Member> findById(ChangePasswordDto id);

    Member findById(Long id);
}
