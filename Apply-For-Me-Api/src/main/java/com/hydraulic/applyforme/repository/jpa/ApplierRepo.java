package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Applier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ApplierRepo extends JpaRepository<Applier, Long> {

    @Query(value = "SELECT * FROM member m JOIN applier a on a.member_id = m.id\n" +
            "WHERE (m.first_name like %:q% OR  m.last_name like %:q% OR  m.username like %:q%)", nativeQuery = true)
    Page<Applier> getStuffs(Pageable pageable, String q);

}
