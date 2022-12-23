package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.dto.admin.ApplierResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSubmissionRepository extends JpaRepository<Submission,Long> {
     @Query("SELECT count (jb) FROM Submission jb where jb.applier.id = ?1")
     Long countByApplier(Long id);
     @Query(value = "SELECT * FROM job_submission where (job_title like %:q% or created_on like %:q% or job_location_type like %:q% or job_company like %:q%)", nativeQuery = true)
     Page<Submission> findJobSubmissionBySearch(Pageable pageable, String q);
     @Query("SELECT count(jb) FROM Submission jb where jb.professional.id = ?1")
     Long countByProfessional(Long id);

     @Query(value = "SELECT applier_id AS ApplierId, COUNT(applier_id) AS ValueOccurrence from job_submission GROUP BY ApplierId ORDER BY COUNT(ApplierId) DESC ", nativeQuery = true)
     List<ApplierResponse> getHighestApplier();

     @Query("SELECT sbm FROM Submission sbm WHERE sbm.applier.id = :id")
     Page<Submission> getSubmissionsProfessional(Long id, Pageable pageable);

     @Query(value = "SELECT s FROM Submission s INNER JOIN ProfessionalProfile pp ON s.professional.id = pp.professional.id WHERE s.professional.id = :id")
     Page<Submission> getSubmissions(Long id, Pageable pageable);

     @Query("SELECT COUNT (sbm) FROM Submission sbm")
     Long countSubmission();

     @Query (value = "SELECT s from Submission s where s.professional.member.id = ?1 ")
     List<Submission> findAllByProfessionalId(@Param("id") Long id);

     @Query (value = "SELECT count(s) from Submission s where s.professional.id = ?1 ")
     Long countSubmissionByProfessional(@Param("id") Long id);
}
