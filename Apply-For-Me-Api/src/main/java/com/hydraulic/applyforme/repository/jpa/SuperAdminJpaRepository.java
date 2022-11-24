package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SuperAdminJpaRepository extends JpaRepository<Member, Long> {

//    @Query("select m from Member m where m.id = ?1")
//    Member viewAdminDetails(Long id);
}
