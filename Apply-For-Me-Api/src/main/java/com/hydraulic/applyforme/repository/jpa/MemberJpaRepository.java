package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
<<<<<<< HEAD

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    Member findByEmailAddress(String emailAddress);
    boolean existsByEmailAddress(String emailAddress);
=======
@Repository
public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    public Member findByEmailAddress(String emailAddress);
    boolean existsByEmailAddress(String emailAddress);

>>>>>>> origin/feat/BE-22-add-applicant-revision
}
