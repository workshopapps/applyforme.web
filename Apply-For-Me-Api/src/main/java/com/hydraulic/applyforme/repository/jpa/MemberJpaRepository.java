package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    Member findByEmailAddress(String emailAddress);
    Member findMemberByEmailAddressIgnoreCase(String emailAddress);
    boolean existsByEmailAddress(String emailAddress);
}
