package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.JobTitle;
import com.hydraulic.applyforme.model.exception.JobTitleDuplicateEntityException;
import com.hydraulic.applyforme.repository.JobTitleRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class JobTitleRepositoryImpl implements JobTitleRepository {

    private static final int DEFAULT_PAGE_SIZE = 11;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<JobTitle> getAll() {
        String queryText = "select jt from JobTitle jt order by jt.updatedOn desc";
        TypedQuery<JobTitle> applyForMeQuery = entityManager.createQuery(queryText, JobTitle.class);
        return applyForMeQuery.getResultList();
    }

    @Override
    public List<JobTitle> getAll(Integer pageOffset) {
        String queryText = "select jt from JobTitle jt order by jt.updatedOn desc";
        TypedQuery<JobTitle> applyForMeQuery = entityManager.createQuery(queryText, JobTitle.class);

        applyForMeQuery.setFirstResult((pageOffset - 1) * DEFAULT_PAGE_SIZE);
        applyForMeQuery.setMaxResults(DEFAULT_PAGE_SIZE);
        return applyForMeQuery.getResultList();
    }

    @Override
    public JobTitle getOne(Long id) {
        return entityManager.find(JobTitle.class, id);
    }

    @Override
    public JobTitle getRef(Long id) {
        try {
            return entityManager.getReference(JobTitle.class, id);
        }
        catch (EntityNotFoundException ex) {
            return null;
        }
    }

    @Override
    public JobTitle saveOne(JobTitle body) {
        try {
            entityManager.persist(body);
            return body;
        }
        catch (EntityExistsException ex) {
            throw new JobTitleDuplicateEntityException();
        }
    }

    @Override
    public JobTitle updateOne(JobTitle body) {
        return entityManager.merge(body);
    }

    @Override
    public boolean remove(Long id) {
        try {
            JobTitle country = entityManager.getReference(JobTitle.class, id);
            entityManager.remove(country);
            return true;
        }
        catch (EntityNotFoundException ex) {
            return false;
        }
    }

    @Override
    public boolean removeMany(List<Long> ids) {
        Query query = entityManager.createQuery("delete from JobTitle jt where jt.id in (:ids)");
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
        Query query = entityManager.createQuery("delete from JobTitle");
        if (query.executeUpdate() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
