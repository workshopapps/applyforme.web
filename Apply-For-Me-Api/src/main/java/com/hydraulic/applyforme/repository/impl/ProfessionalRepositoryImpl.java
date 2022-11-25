package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Professional;

import com.hydraulic.applyforme.model.exception.ProffesionalDuplicateEntityException;
import com.hydraulic.applyforme.repository.ProfessionalRepository;

import javax.persistence.EntityExistsException;
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

    @Override
    public List<Professional> getAll() {
        String queryText = "select * from professional";
        TypedQuery<Professional> applyForMeQuery = entityManager.createQuery(queryText, Professional.class);
        return applyForMeQuery.getResultList();
    }

    @Override
    public List<Professional> getAll(Integer pageOffset) {
        String queryText = "select * from professional";
        TypedQuery<Professional> applyForMeQuery = entityManager.createQuery(queryText, Professional.class);

        applyForMeQuery.setFirstResult((int) ((pageOffset - 1) * DEFAULT_PAGE_SIZE));
        applyForMeQuery.setMaxResults(DEFAULT_PAGE_SIZE);
        return applyForMeQuery.getResultList();

    }

    @Override
    public Professional getOne(Long id) {
        return entityManager.find(Professional.class, id);
    }

    @Override
    public Professional saveOne(Professional body) {
        try {
            entityManager.persist(body);
            return body;
        }
        catch (EntityExistsException ex) {
            throw new ProffesionalDuplicateEntityException();
        }
    }

    @Override
    public Professional updateOne(Professional body) {
        return entityManager.merge(body);
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

}
