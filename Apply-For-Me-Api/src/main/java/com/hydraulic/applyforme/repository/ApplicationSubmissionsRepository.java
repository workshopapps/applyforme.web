package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Submission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationSubmissionsRepository /*extends JpaRepository<Submission, Long>*/ {

    Page<Submission> getAllSubmissions(List<Submission> submissions, Pageable pageable);
}
