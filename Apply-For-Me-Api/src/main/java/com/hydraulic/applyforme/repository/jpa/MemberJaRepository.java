package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJaRepository extends JpaRepository<Member, Long> {

    boolean existsByEmailAddress(String email);
}
