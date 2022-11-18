package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JobSubmissionRepository extends JpaRepository<Submission,Long> {
     List<Submission> findSubmissionByApplier(Applier applier);
}
