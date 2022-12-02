package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.util.CurrentUserUtil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperAdminJpaRepository extends JpaRepository<Member, Long> {
    Member findById(CurrentUserUtil currentUserUtil);

//    @Query("select m from Member m where m.id = ?1")
//    Member viewAdminDetails(Long id);
}
