package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    boolean existsByEmailAddress(String emailAddress);

    Member findByEmail(String emailAddress); //method that returns member object based on email address

}


