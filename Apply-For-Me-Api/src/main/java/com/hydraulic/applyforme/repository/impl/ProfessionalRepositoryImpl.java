package com.hydraulic.applyforme.repository.impl;

<<<<<<< HEAD
import com.hydraulic.applyforme.model.domain.Professional;

import com.hydraulic.applyforme.model.dto.applicant.ApplicantJobProfileDto;
import com.hydraulic.applyforme.repository.ProfessionalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
=======

import java.util.List;
>>>>>>> d1209ce9e517735fb2e20059e2fb0d05cea48f05

import javax.persistence.*;

import com.hydraulic.applyforme.model.exception.ProfessionalDuplicateEntityException;
import org.springframework.stereotype.Repository;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.repository.ProfessionalRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ProfessionalRepositoryImpl implements ProfessionalRepository {

    private static final int DEFAULT_PAGE_SIZE = 11;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Professional> getAll(Integer pageOffset) {
        String queryString = "select p from Professional p order by p.member.updatedOn desc";
        TypedQuery<Professional> professionalQuery = entityManager.createQuery(queryString, Professional.class);

        professionalQuery.setFirstResult((pageOffset - 1) * DEFAULT_PAGE_SIZE);
        professionalQuery.setMaxResults(DEFAULT_PAGE_SIZE);
        return professionalQuery.getResultList();
    }

    @Override
    public Professional getOne(Long id) {
    	String query = "select p from Professional p where p.member.id = :id";
    	TypedQuery<Professional> professional = entityManager.createQuery(query, Professional.class);
    	professional.setParameter("id", id);
        return professional.getSingleResult();
    }

    @Override
    public Professional getRef(Long id) {
        try {
            return entityManager.getReference(Professional.class, id);
        }
        catch (EntityNotFoundException ex) {
            return null;
        }
    }

    @Override
    public boolean remove(Long id) {
        try {
            Professional entity = entityManager.getReference(Professional.class, id);
            entityManager.remove(entity);
            return true;
        }
        catch (EntityNotFoundException ex) {
            return false;
        }
    }

    @Override
    public boolean removeMany(List<Long> ids) {
        Query query = entityManager.createQuery("delete from Professional p where p.id in (:ids)");
        query.setParameter("ids", ids);
        if (query.executeUpdate() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean removeAll() {
        Query query = entityManager.createQuery("delete from Professional");
        if (query.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateOne(Professional body) {
    	Professional merge = entityManager.merge(body);
    	return true;
    }

    @Override
<<<<<<< HEAD
    public int updateProfile(ApplicantJobProfileDto body) {
        String querstr = "UPDATE professional_profile SET profile_title = :profileTitle, " +
                "main_profile = :mainProfile, " +
                "passport_link = :passportLink, " +
                "resume_link = :resumeLink, " +
                "cover_letter = :coverLetter, " +
                "salary_range = :salaryRange, " +
                "employment_type = :employmentType, " +
                "job_location = :jobLocation, " +
                "preferred_job_location_type = :preferredJobLocationType, " +
                "job_seniority = :jobSeniority, " +
                "desired_job_title = :desiredJobTitle, " +
                "industry = :industry, " +
                "years_of_experience = :yearsOfExperience, " +
                "other_skills = :otherSkills, " +
                "other_comment = :otherComment, " +
                "included_keywords = :includedKeywords, " +
                "updated_on = :updatedOn";
        Query query = entityManager.createNativeQuery(querstr);
        query.setParameter("otherComment",  body.getOtherComment());
        query.setParameter( "otherSkills", body.getOtherSkills());
        query.setParameter("coverLetter",  body.getCover_letter());
        query.setParameter( "mainProfile", body.getMainProfile());
        query.setParameter( "profileTitle", body.getProfileTitle());
        query.setParameter( "yearsOfExperience", body.getYearsOfExperience());
        query.setParameter( "preferredJobLocationType", body.getPreferredJobLocationType());
        query.setParameter( "salaryRange", body.getSalaryRange());
        query.setParameter( "resumeLink", body.getResumeLink());
        query.setParameter("passportLink",  body.getPassportLink());
        query.setParameter("jobSeniority",  body.getJobSeniority());
        query.setParameter( "jobLocation", body.getJobLocation());
        query.setParameter( "includedKeywords", body.getIncludedKeywords());
        query.setParameter( "employmentType", body.getEmploymentType());
        query.setParameter( "industry", body.getIndustry());
        query.setParameter( "desiredJobTitle", body.getDesiredJobTitle());
        query.setParameter( "updatedOn", body.getUpdatedOn());
        int rowsUpdated = query.executeUpdate();
        return rowsUpdated;
    }
=======
    public Professional saveOne(Professional body) {
        try {
            entityManager.persist(body);
            return body;
        }
        catch (EntityExistsException ex) {
            throw new ProfessionalDuplicateEntityException();
        }
    }
    
>>>>>>> d1209ce9e517735fb2e20059e2fb0d05cea48f05
}
