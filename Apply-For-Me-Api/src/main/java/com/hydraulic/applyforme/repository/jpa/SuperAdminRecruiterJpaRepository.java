package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SuperAdminRecruiterJpaRepository extends JpaRepository<Member, Long> {

    @Query(value = "select m FROM Member m inner join m.roles rl where rl.code ='Recruiter' AND " +
            "(m.firstName like '%' || :q || '%' or m.lastName like '%' || :q || '%')")
    Page<Member> searchRecruiterByName(Pageable pageable, String q);
}
