package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

public interface SuperAdminApplierJpaRepository extends JpaRepository<Member, Long> {

    @Query(value = "select m FROM Member m inner join m.roles rl where rl.code ='Recruiter' AND " +
            "(m.firstName like '%' || :q || '%' or m.lastName like '%' || :q || '%' or " +
            "m.createdOn like '%' || :q || '%' or m.currentJobTitle like '%' || :q || '%' or m.city like '%' || :q || '%' or m.state like '%' || :q || '%')")
    Page<Member> getEntries(String q, Pageable pageable);
    @Query(value = "select m FROM Member m inner join m.roles rl where rl.code ='Recruiter'")
    Page<Member> getEntries(Pageable pageable);

    @Query(value = "select m FROM Member m inner join m.roles rl where rl.code ='Recruiter' AND " +
            "(m.createdOn between :from AND :to) AND " +
            "(m.firstName like '%' || :q || '%' or m.lastName like '%' || :q || '%' or " +
            "m.currentJobTitle like '%' || :q || '%' or m.city like '%' || :q || '%' or m.state like '%' || :q || '%')")
    Page<Member> getEntries(Date from, Date to, String q, Pageable pageable);

    @Query(value = "select m FROM Member m inner join m.roles rl where rl.code ='Recruiter' AND " +
            "(m.createdOn BETWEEN :from AND :to)")
    Page<Member> getEntries(Date from, Date to, Pageable pageable);

    @Query(value = "select m FROM Member m inner join m.roles rl where rl.code ='Recruiter' AND " +
            "m.createdOn <= :to AND " +
            "(m.firstName like '%' || :q || '%' or m.lastName like '%' || :q || '%' or " +
            "m.currentJobTitle like '%' || :q || '%' or m.city like '%' || :q || '%' or m.state like '%' || :q || '%')")
    Page<Member> getEntries(Date to, String q, Pageable pageable);

    @Query(value = "select m FROM Member m inner join m.roles rl where rl.code ='Recruiter' AND " +
            "m.createdOn >= :from AND " +
            "(m.firstName like '%' || :q || '%' or m.lastName like '%' || :q || '%' or " +
            "m.currentJobTitle like '%' || :q || '%' or m.city like '%' || :q || '%' or m.state like '%' || :q || '%')")
    Page<Member> getEntries(String q, Date from, Pageable pageable);

    Page<Member> findMembersByRoles(Pageable paging, Optional<Role> existingRole);
}
