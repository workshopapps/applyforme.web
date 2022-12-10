package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.exception.ProfessionalProfileDuplicateEntityException;
import com.hydraulic.applyforme.repository.ProfessionalProfileRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class ProfessionalProfileRepositoryImpl implements ProfessionalProfileRepository {

    private static final int DEFAULT_PAGE_SIZE = 11;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProfessionalProfile> getAll() {
        String queryText = "select pp from ProfessionalProfile pp order by pp.updatedOn desc";
        TypedQuery<ProfessionalProfile> applyForMeQuery = entityManager.createQuery(queryText, ProfessionalProfile.class);
        return applyForMeQuery.getResultList();
    }

    @Override
    public List<ProfessionalProfile> getAll(Integer pageOffset) {
        String queryText = "select pp from ProfessionalProfile pp order by pp.updatedOn desc";
        TypedQuery<ProfessionalProfile> applyForMeQuery = entityManager.createQuery(queryText, ProfessionalProfile.class);

        applyForMeQuery.setFirstResult((pageOffset - 1) * DEFAULT_PAGE_SIZE);
        applyForMeQuery.setMaxResults(DEFAULT_PAGE_SIZE);
        return applyForMeQuery.getResultList();
    }

    @Override
    public ProfessionalProfile getOne(Long id) {
        return entityManager.find(ProfessionalProfile.class, id);
    }

    @Override
    public ProfessionalProfile getRef(Long id) {
        try {
            return entityManager.getReference(ProfessionalProfile.class, id);
        }
        catch (EntityNotFoundException ex) {
            return null;
        }
    }

    @Override
    public ProfessionalProfile saveOne(ProfessionalProfile body) {
        try {
            entityManager.persist(body);
            return body;
        }
        catch (EntityExistsException ex) {
            throw new ProfessionalProfileDuplicateEntityException();
        }
    }

    @Override
    public ProfessionalProfile updateOne(ProfessionalProfile body) {
        return entityManager.merge(body);
    }

    @Override
    public boolean remove(Long id) {
        try {
            ProfessionalProfile country = entityManager.getReference(ProfessionalProfile.class, id);
            entityManager.remove(country);
            return true;
        }
        catch (EntityNotFoundException ex) {
            return false;
        }
    }

    @Override
    public boolean removeMany(List<Long> ids) {
        Query query = entityManager.createQuery("delete from ProfessionalProfile pp where pp.id in (:ids)");
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
        Query query = entityManager.createQuery("delete from ProfessionalProfile");
        if (query.executeUpdate() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean deleteJobProfile(Long id) {
        return true;
    }


}
