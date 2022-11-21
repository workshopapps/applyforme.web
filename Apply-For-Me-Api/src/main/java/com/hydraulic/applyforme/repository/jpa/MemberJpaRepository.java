package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface MemberJpaRepository {   //extends JpaRepository<Member, Long> {
    public Member findByEmailAddress(String emailAddress);
    public void save(Member member);
    boolean existsByEmailAddress(String emailAddress);
    public void updatePassword(String emailAddress, String newPassword);
}
