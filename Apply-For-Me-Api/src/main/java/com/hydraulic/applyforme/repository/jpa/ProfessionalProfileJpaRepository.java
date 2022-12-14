package com.hydraulic.applyforme.repository.jpa;

import java.util.Date;
import java.util.List;

import com.hydraulic.applyforme.model.domain.Submission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hydraulic.applyforme.model.domain.ProfessionalProfile;

public interface ProfessionalProfileJpaRepository extends JpaRepository<ProfessionalProfile, Long> {

    @Query("SELECT count (pp) FROM ProfessionalProfile pp where pp.professional.id = ?1")
    Long countByProfessional(Long id);
    
    @Query("select pp from ProfessionalProfile pp where pp.professional.member.id = :id")
    List<ProfessionalProfile> getJobProfiles(@Param("id") Long member_id);


    @Query("select j from ProfessionalProfile j")
    List<ProfessionalProfile> getAllJobProfileSubmission();

    @Query(value = "select pp FROM ProfessionalProfile pp where " +
            "(pp.profileTitle like '%' || :q || '%' or pp.jobLocation like '%' || :q || '%' or " +
            "pp.desiredJobTitle like '%' || :q || '%' or pp.includedKeywords like '%' || :q || '%')")
    Page<ProfessionalProfile> getEntries(String q, Pageable pageable);

    @Query(value = "select pp FROM ProfessionalProfile pp")
    Page<ProfessionalProfile> getEntries(Pageable pageable);

    @Query(value = "select pp FROM ProfessionalProfile pp where " +
            "(pp.createdOn between :from AND :to) AND " +
            "(pp.profileTitle like '%' || :q || '%' or pp.jobLocation like '%' || :q || '%' or " +
            "pp.desiredJobTitle like '%' || :q || '%' or pp.includedKeywords like '%' || :q || '%')")
    Page<ProfessionalProfile> getEntries(Date from, Date to, String q, Pageable pageable);

    @Query(value = "select pp FROM ProfessionalProfile pp where (pp.createdOn BETWEEN :from AND :to)")
    Page<ProfessionalProfile> getEntries(Date from, Date to, Pageable pageable);

    @Query(value = "select pp FROM ProfessionalProfile pp where " +
            "pp.createdOn <= :to AND " +
            "(pp.profileTitle like '%' || :q || '%' or pp.jobLocation like '%' || :q || '%' or " +
            "pp.desiredJobTitle like '%' || :q || '%' or pp.includedKeywords like '%' || :q || '%')")
    Page<ProfessionalProfile> getEntries(Date to, String q, Pageable pageable);

    @Query(value = "select pp FROM ProfessionalProfile pp where " +
            "pp.createdOn >= :from AND " +
            "(pp.profileTitle like '%' || :q || '%' or pp.jobLocation like '%' || :q || '%' or " +
            "pp.desiredJobTitle like '%' || :q || '%' or pp.includedKeywords like '%' || :q || '%')")
    Page<ProfessionalProfile> getEntries(String q, Date from, Pageable pageable);



    @Query(value = "select pp FROM ProfessionalProfile pp where pp.professional.member.id = :id AND " +
            "(pp.profileTitle like '%' || :q || '%' or pp.jobLocation like '%' || :q || '%' or " +
            "pp.desiredJobTitle like '%' || :q || '%' or pp.includedKeywords like '%' || :q || '%')")
    Page<ProfessionalProfile> getUserEntries(String q, Long id, Pageable pageable);

    @Query(value = "select pp FROM ProfessionalProfile pp where pp.professional.member.id = :id")
    Page<ProfessionalProfile> getUserEntries(Long id, Pageable pageable);

    @Query(value = "select pp FROM ProfessionalProfile pp where pp.professional.member.id = :id AND " +
            "(pp.createdOn between :from AND :to) AND " +
            "(pp.profileTitle like '%' || :q || '%' or pp.jobLocation like '%' || :q || '%' or " +
            "pp.desiredJobTitle like '%' || :q || '%' or pp.includedKeywords like '%' || :q || '%')")
    Page<ProfessionalProfile> getUserEntries(Date from, Date to, String q, Long id, Pageable pageable);

    @Query(value = "select pp FROM ProfessionalProfile pp where pp.professional.member.id = :id AND (pp.createdOn BETWEEN :from AND :to)")
    Page<ProfessionalProfile> getUserEntries(Date from, Date to, Long id, Pageable pageable);

    @Query(value = "select pp FROM ProfessionalProfile pp where pp.professional.member.id = :id AND " +
            "pp.createdOn <= :to AND " +
            "(pp.profileTitle like '%' || :q || '%' or pp.jobLocation like '%' || :q || '%' or " +
            "pp.desiredJobTitle like '%' || :q || '%' or pp.includedKeywords like '%' || :q || '%')")
    Page<ProfessionalProfile> getUserEntries(Date to, String q, Pageable pageable);

    @Query(value = "select pp FROM ProfessionalProfile pp where pp.professional.member.id = :id AND " +
            "pp.createdOn >= :from AND " +
            "(pp.profileTitle like '%' || :q || '%' or pp.jobLocation like '%' || :q || '%' or " +
            "pp.desiredJobTitle like '%' || :q || '%' or pp.includedKeywords like '%' || :q || '%')")
    Page<ProfessionalProfile> getUserEntries(String q, Date from, Long id, Pageable pageable);

    @Query(value = "select pp FROM ProfessionalProfile pp where pp.professional.member.id = :memberId AND id = :id")
    ProfessionalProfile getOneUserProfessionalProfile(@Param("memberId") Long memberId, Long id);
}
