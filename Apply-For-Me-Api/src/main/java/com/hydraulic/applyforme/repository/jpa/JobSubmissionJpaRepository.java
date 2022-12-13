package com.hydraulic.applyforme.repository.jpa;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.domain.Submission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface JobSubmissionJpaRepository extends JpaRepository<Submission, Long> {

    @Query(value = "select jb FROM Submission jb where " +
            "(jb.jobTitle like '%' || :q || '%' or jb.jobLocation like '%' || :q || '%' or " +
            "jb.jobCompany like '%' || :q || '%' or jb.jobLink like '%' || :q || '%')")
    Page<Submission> getEntries(String q, Pageable pageable);

    @Query(value = "select jb FROM Submission jb")
    Page<Submission> getEntries(Pageable pageable);

    @Query(value = "select jb FROM Submission jb where " +
            "(jb.createdOn between :from AND :to) AND " +
            "(jb.jobTitle like '%' || :q || '%' or jb.jobLocation like '%' || :q || '%' or " +
            "jb.jobCompany like '%' || :q || '%' or jb.jobLink like '%' || :q || '%')")
    Page<Submission> getEntries(Date from, Date to, String q, Pageable pageable);

    @Query(value = "select jb FROM Submission jb where (jb.createdOn BETWEEN :from AND :to)")
    Page<Submission> getEntries(Date from, Date to, Pageable pageable);

    @Query(value = "select jb FROM Submission jb where " +
            "jb.createdOn <= :to AND " +
            "(jb.jobTitle like '%' || :q || '%' or jb.jobLocation like '%' || :q || '%' or " +
            "jb.jobCompany like '%' || :q || '%' or jb.jobLink like '%' || :q || '%')")
    Page<Submission> getEntries(Date to, String q, Pageable pageable);

    @Query(value = "select jb FROM Submission jb where " +
            "jb.createdOn >= :from AND " +
            "(jb.jobTitle like '%' || :q || '%' or jb.jobLocation like '%' || :q || '%' or " +
            "jb.jobCompany like '%' || :q || '%' or jb.jobLink like '%' || :q || '%')")
    Page<Submission> getEntries(String q, Date from, Pageable pageable);



    @Query(value = "select jb FROM Submission jb where jb.professional.member.id = :id AND " +
            "(jb.jobTitle like '%' || :q || '%' or jb.jobLocation like '%' || :q || '%' or " +
            "jb.jobCompany like '%' || :q || '%' or jb.jobLink like '%' || :q || '%')")
    Page<Submission> getUserEntries(String q, Long id, Pageable pageable);

    @Query(value = "select jb FROM Submission jb where jb.professional.member.id = :id")
    Page<Submission> getUserEntries(Long id, Pageable pageable);

    @Query(value = "select jb FROM Submission jb where jb.professional.member.id = :id AND " +
            "(jb.createdOn between :from AND :to) AND " +
            "(jb.jobTitle like '%' || :q || '%' or jb.jobLocation like '%' || :q || '%' or " +
            "jb.jobCompany like '%' || :q || '%' or jb.jobLink like '%' || :q || '%')")
    Page<Submission> getUserEntries(Date from, Date to, String q, Long id, Pageable pageable);

    @Query(value = "select jb FROM Submission jb where jb.professional.member.id = :id AND (jb.createdOn BETWEEN :from AND :to)")
    Page<Submission> getUserEntries(Date from, Date to, Long id, Pageable pageable);

    @Query(value = "select jb FROM Submission jb where jb.professional.member.id = :id AND " +
            "jb.createdOn <= :to AND " +
            "(jb.jobTitle like '%' || :q || '%' or jb.jobLocation like '%' || :q || '%' or " +
            "jb.jobCompany like '%' || :q || '%' or jb.jobLink like '%' || :q || '%')")
    Page<Submission> getUserEntries(Date to, String q, Pageable pageable);

    @Query(value = "select jb FROM Submission jb where jb.professional.member.id = :id AND " +
            "jb.createdOn >= :from AND " +
            "(jb.jobTitle like '%' || :q || '%' or jb.jobLocation like '%' || :q || '%' or " +
            "jb.jobCompany like '%' || :q || '%' or jb.jobLink like '%' || :q || '%')")
    Page<Submission> getUserEntries(String q, Date from, Long id, Pageable pageable);
}
