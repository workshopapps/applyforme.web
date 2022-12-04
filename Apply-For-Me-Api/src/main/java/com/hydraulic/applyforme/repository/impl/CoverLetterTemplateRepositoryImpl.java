package com.hydraulic.applyforme.repository.impl;


import com.hydraulic.applyforme.model.domain.CoverLetterTemplate;
import com.hydraulic.applyforme.model.exception.CoverLetterTemplateDuplicateEntityException;
import com.hydraulic.applyforme.repository.CoverLetterTemplateRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CoverLetterTemplateRepositoryImpl implements CoverLetterTemplateRepository {
    private static final int DEFAULT_PAGE_SIZE = 11;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CoverLetterTemplate> getAll() {
        String queryText = "select clt from CoverLetterTemplate clt order by clt.updatedOn desc";
        TypedQuery<CoverLetterTemplate> applyForMeQuery = entityManager.createQuery(queryText, CoverLetterTemplate.class);
        return applyForMeQuery.getResultList();
    }

    @Override
    public List<CoverLetterTemplate> getAll(Integer pageOffset) {
        String queryText = "select clt from CoverLetterTemplate clt order by clt.updatedOn desc";
        TypedQuery<CoverLetterTemplate> applyForMeQuery = entityManager.createQuery(queryText, CoverLetterTemplate.class);

        applyForMeQuery.setFirstResult((pageOffset - 1) * DEFAULT_PAGE_SIZE);
        applyForMeQuery.setMaxResults(DEFAULT_PAGE_SIZE);
        return applyForMeQuery.getResultList();
    }

    @Override
    public CoverLetterTemplate getOne(Long id) {
        return entityManager.find(CoverLetterTemplate.class, id);
    }

    @Override
    public CoverLetterTemplate getRef(Long id) {
        try {
            return entityManager.getReference(CoverLetterTemplate.class, id);
        }
        catch (EntityNotFoundException ex) {
            return null;
        }
    }

    @Override
    public CoverLetterTemplate saveOne(CoverLetterTemplate body) {
        try {
            entityManager.persist(body);
            return body;
        }
        catch (EntityExistsException ex) {
            throw new CoverLetterTemplateDuplicateEntityException();
        }
    }

    @Override
    public CoverLetterTemplate updateOne(CoverLetterTemplate body) {
        return entityManager.merge(body);
    }

    @Override
    public boolean remove(Long id) {
        try {
            CoverLetterTemplate country = entityManager.getReference(CoverLetterTemplate.class, id);
            entityManager.remove(country);
            return true;
        }
        catch (EntityNotFoundException ex) {
            return false;
        }
    }

    @Override
    public boolean removeMany(List<Long> ids) {
        Query query = entityManager.createQuery("delete from CoverLetterTemplate clt where clt.id in (:ids)");
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
        Query query = entityManager.createQuery("delete from CoverLetterTemplate");
        if (query.executeUpdate() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
