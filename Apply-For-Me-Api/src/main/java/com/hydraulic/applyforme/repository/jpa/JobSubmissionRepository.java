package com.hydraulic.applyforme.repository.jpa;


import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Country;

import com.hydraulic.applyforme.model.domain.Submission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


@Repository
public interface JobSubmissionRepository extends JpaRepository<Submission,Long> {

     @Query("SELECT count (jb) FROM Submission jb where jb.applier.id = ?1")
     Long countByApplier(Long id);



     @Query(value = "SELECT * FROM job_submission u  where (job_title like %:q% or created_on like %:q% or job_location_type like %:q% or job_company)", nativeQuery = true)
     Optional<List<Submission>> findJobSubmissionBySearch(String q);
}
