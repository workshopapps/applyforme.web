package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.SalaryRange;
import com.hydraulic.applyforme.model.domain.SalaryRange;
import com.hydraulic.applyforme.model.exception.SalaryRangeDuplicateEntityException;
import com.hydraulic.applyforme.repository.SalaryRangeRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class SalaryRangeRepositoryImpl implements SalaryRangeRepository {

    private static final int DEFAULT_PAGE_SIZE = 11;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SalaryRange> getAll() {
        String queryText = "select sr from SalaryRange sr order by sr.updatedOn desc";
        TypedQuery<SalaryRange> applyForMeQuery = entityManager.createQuery(queryText, SalaryRange.class);
        return applyForMeQuery.getResultList();
    }

    @Override
    public List<SalaryRange> getAll(Integer pageOffset) {
        String queryText = "select sr from SalaryRange sr order by sr.updatedOn desc";
        TypedQuery<SalaryRange> applyForMeQuery = entityManager.createQuery(queryText, SalaryRange.class);

        applyForMeQuery.setFirstResult((pageOffset - 1) * DEFAULT_PAGE_SIZE);
        applyForMeQuery.setMaxResults(DEFAULT_PAGE_SIZE);
        return applyForMeQuery.getResultList();
    }

    @Override
    public SalaryRange getOne(Long id) {
        return entityManager.find(SalaryRange.class, id);
    }

    @Override
    public SalaryRange saveOne(SalaryRange body) {
        try {
            entityManager.persist(body);
            return body;
        }
        catch (EntityExistsException ex) {
            throw new SalaryRangeDuplicateEntityException();
        }
    }

    @Override
    public SalaryRange updateOne(SalaryRange body) {
        return entityManager.merge(body);
    }

    @Override
    public boolean remove(Long id) {
        try {
            SalaryRange applyForMe = entityManager.getReference(SalaryRange.class, id);
            entityManager.remove(applyForMe);
            return true;
        }
        catch (EntityNotFoundException ex) {
            return false;
        }
    }

    @Override
    public boolean removeMany(List<Long> ids) {
        Query query = entityManager.createQuery("delete from SalaryRange sr where sr.id in (:ids)");
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
        Query query = entityManager.createQuery("delete from SalaryRange");
        if (query.executeUpdate() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
