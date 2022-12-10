package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.SalaryRange;
import com.hydraulic.applyforme.model.domain.Submission;

import com.hydraulic.applyforme.model.dto.professional.ProfessionalDto;
import com.hydraulic.applyforme.repository.ProfessionalRepository;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

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
        return entityManager.find(Professional.class, id);
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
    public Professional updateOne(Professional body) {
        return entityManager.merge(body);
    }

    /*
    public Professional updateOne(Professional body) {
        String sql1 = "UPDATE professional " +
                "SET available_for_interview = :availableForInterview," +
                " linkedin_link = :linkedinLink," +
                " facebook_link = :facebookLink," +
                " twitter_link = :twitterLink," +
                " instagram_link = :instagramLink," +
                " hobbies = :hobbies," +
                " other_link_1 = :otherLink1," +
                " other_link_2 = :otherLink2," +
                " other_link_3 = :otherLink3," +
                " WHERE id = :pid";
        int rowsupdated;
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction.begin();
            Query query = entityManager.createNativeQuery(sql1);
            query.setParameter("availableForInterview", body.isAvailableForInterview());
            query.setParameter("linkedinLink", body.getLinkedinLink());
            query.setParameter("facebookLink", body.getFacebookLink());
            query.setParameter("twitterLink", body.getTwitterLink());
            query.setParameter("instagramLink", body.getInstagramLink());
            query.setParameter("hobbies", body.getHobbies());
            query.setParameter("otherLink1", body.getOtherLink1());
            query.setParameter("otherLink2", body.getOtherLink1());
            query.setParameter("otherLink3",body.getOtherLink2();
            query.setParameter("pid", body.getId());
            rowsupdated = query.executeUpdate();
            entityTransaction.commit();
        } catch (Exception ex) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            System.out.println("Exception: " + ex.getMessage());
            rowsupdated = 0;
        }
        String sql2 ="SELECT * FROM professional WHERE id = " + body.getId() + "";
        Query query = entityManager.createNativeQuery(sql2);
        Professional professional = (Professional) query.getSingleResult();
        return professional;
    }
    */
}
