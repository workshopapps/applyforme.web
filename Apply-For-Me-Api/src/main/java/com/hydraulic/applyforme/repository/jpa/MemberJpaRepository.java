package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    Member findByEmailAddress(String emailAddress);
    boolean existsByEmailAddress(String emailAddress);
}
