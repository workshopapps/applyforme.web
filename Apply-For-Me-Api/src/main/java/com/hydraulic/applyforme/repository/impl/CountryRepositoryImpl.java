package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.exception.CounntryDuplicateEntityException;
import com.hydraulic.applyforme.repository.CountryRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CountryRepositoryImpl implements CountryRepository {

    private static final int DEFAULT_PAGE_SIZE = 11;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Country> getAll() {
        String queryText = "select c from Country c order by c.updatedOn desc";
        TypedQuery<Country> applyForMeQuery = entityManager.createQuery(queryText, Country.class);
        return applyForMeQuery.getResultList();
    }

    @Override
    public List<Country> getAll(Integer pageOffset) {
        String queryText = "select c from Country c order by c.updatedOn desc";
        TypedQuery<Country> applyForMeQuery = entityManager.createQuery(queryText, Country.class);

        applyForMeQuery.setFirstResult((pageOffset - 1) * DEFAULT_PAGE_SIZE);
        applyForMeQuery.setMaxResults(DEFAULT_PAGE_SIZE);
        return applyForMeQuery.getResultList();
    }

    @Override
    public Country getOne(Long id) {
        return entityManager.find(Country.class, id);
    }

    @Override
    public Country saveOne(Country body) {
        try {
            entityManager.persist(body);
            return body;
        }
        catch (EntityExistsException ex) {
            throw new CounntryDuplicateEntityException();
        }
    }

    @Override
    public Country updateOne(Country body) {
        return entityManager.merge(body);
    }

    @Override
    public boolean remove(Long id) {
        try {
            Country applyForMe = entityManager.getReference(Country.class, id);
            entityManager.remove(applyForMe);
            return true;
        }
        catch (EntityNotFoundException ex) {
            return false;
        }
    }

    @Override
    public boolean removeMany(List<Long> countryIds) {
        Query query = entityManager.createQuery("delete from Country c where c.id in (:ids)");
        query.setParameter("ids", countryIds);
        if (query.executeUpdate() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean removeAll() {
        Query query = entityManager.createQuery("delete from Country");
        if (query.executeUpdate() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
