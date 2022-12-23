package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Submission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SuperAdminRecruiterJpaRepository extends JpaRepository<Member, Long> {

    @Query(value = "select m FROM Member m inner join m.roles rl where rl.code ='RECRUITERS' AND " +
            "(m.firstName LIKE %:firstName%)")
    Member searchRecruiterByName(@Param("firstName") String firstName);

//    @Query(value = "select m FROM Member m inner join m.roles rl where rl.code ='Recruiter' AND m.id = :id")
//    Page<Member> getMember(@Param("id") Long id, Pageable pageable);

    @Query(value = "select s FROM Submission s where s.applier.id = :id")
    Page<Submission> getMember(@Param("id") Long id, Pageable pageable);
}
