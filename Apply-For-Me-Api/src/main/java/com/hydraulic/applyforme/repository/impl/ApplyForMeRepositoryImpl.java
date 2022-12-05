package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.ApplyForMe;
import com.hydraulic.applyforme.model.exception.ApplyForMeDuplicateEntityException;
import com.hydraulic.applyforme.repository.ApplyForMeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;
@Repository
public class ApplyForMeRepositoryImpl implements ApplyForMeRepository {

    private static final int DEFAULT_PAGE_SIZE = 11;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ApplyForMe> getAll(Integer pageOffset) {
        String queryText = "select afm from ApplyForMe afm order by afm.updatedOn desc";
        TypedQuery<ApplyForMe> applyForMeQuery = entityManager.createQuery(queryText, ApplyForMe.class);

        applyForMeQuery.setFirstResult((pageOffset - 1) * DEFAULT_PAGE_SIZE);
        applyForMeQuery.setMaxResults(DEFAULT_PAGE_SIZE);
        return applyForMeQuery.getResultList();
    }

    @Override
    public ApplyForMe getOne(Long id) {
        return entityManager.find(ApplyForMe.class, id);
    }

    @Override
    public ApplyForMe saveOne(ApplyForMe body) {
        try {
            entityManager.persist(body);
            return body;
        }
        catch (EntityExistsException ex) {
            throw new ApplyForMeDuplicateEntityException();
        }
    }

    @Override
    public ApplyForMe updateOne(ApplyForMe body) {
        return entityManager.merge(body);
    }

    @Override
    public boolean remove(Long id) {
        try {
            ApplyForMe applyForMe = entityManager.getReference(ApplyForMe.class, id);
            entityManager.remove(applyForMe);
            return true;
        }
        catch (EntityNotFoundException ex) {
            return false;
        }
    }

    @Override
    public boolean removeMany(List<Long> ids) {
        Query query = entityManager.createQuery("delete from ApplyForMe afm where afm.id in (:ids)");
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
        Query query = entityManager.createQuery("delete from ApplyForMe");
        if (query.executeUpdate() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
