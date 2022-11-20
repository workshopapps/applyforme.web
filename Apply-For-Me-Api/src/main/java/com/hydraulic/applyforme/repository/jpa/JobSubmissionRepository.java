package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Submission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface JobSubmissionRepository extends JpaRepository<Submission,Long> {

     @Query("SELECT count (jb) FROM Submission jb where jb.applier.id = ?1")
     Long countByApplier(Long id);
}
