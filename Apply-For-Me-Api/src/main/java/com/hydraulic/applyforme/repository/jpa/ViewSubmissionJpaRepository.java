package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ViewSubmissionJpaRepository extends JpaRepository<Submission, Long> {
    List<Submission> findAllByDate(String date);
}
