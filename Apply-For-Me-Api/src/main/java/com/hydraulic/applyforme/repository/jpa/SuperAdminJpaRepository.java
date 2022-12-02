package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface SuperAdminJpaRepository extends JpaRepository<Member, Long> {

    Member findMemberByRoles(Optional<Role> role);
    Page<Member> findMemberByRoles(Pageable pageable, Optional<Role> role);

    @Override
    List<Member> findAll();
    //    @Query("select m from Member m where m.id = ?1")
//    Member viewAdminDetails(Long id);
}
