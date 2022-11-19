package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JobSubmissionRepository extends CrudRepository<Submission,Long> {

     @Query("SELECT count (jb) FROM Submission jb where jb.applier.id= ?1")
     Long countByApplier(Long id);
}
