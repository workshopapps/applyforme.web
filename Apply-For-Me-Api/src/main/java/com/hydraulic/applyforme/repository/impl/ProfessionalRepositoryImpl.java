package com.hydraulic.applyforme.repository.impl;


import java.util.List;

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
    public Professional saveOne(Professional body) {
        try {
            entityManager.persist(body);
            return body;
        }
        catch (EntityExistsException ex) {
            throw new ProfessionalDuplicateEntityException();
        }
    }
    
}
