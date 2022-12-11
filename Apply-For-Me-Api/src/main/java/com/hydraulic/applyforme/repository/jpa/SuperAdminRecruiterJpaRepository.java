package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SuperAdminRecruiterJpaRepository extends JpaRepository<Member, Long> {

    @Query(value = "select m FROM Member m inner join m.roles rl where rl.code ='RECRUITERS' AND " +
            "(m.firstName LIKE %:firstName%)")
    Member searchRecruiterByName(@Param("firstName") String firstName);
}
