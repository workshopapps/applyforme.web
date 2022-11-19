package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Submission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ApplicationSubmissionsRepository extends ApplyForMeRepository {

    Page<Submission> getAllSubmissions(List<Submission> submissions, Pageable pageable);

}
