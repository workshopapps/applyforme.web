package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {


    public Member findByEmailAddress(String emailAddress);
    public List<Member> findAll();
    boolean existsByEmailAddress(String emailAddress);
}
