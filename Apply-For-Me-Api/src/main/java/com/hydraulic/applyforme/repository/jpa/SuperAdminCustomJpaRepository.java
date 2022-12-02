package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Submission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SuperAdminCustomJpaRepository extends JpaRepository<Submission, Long> {

    @Query("SELECT s FROM Submission s ORDER BY s.updatedOn DESC")
    Page<Submission> findAll(Pageable pageable);
}
