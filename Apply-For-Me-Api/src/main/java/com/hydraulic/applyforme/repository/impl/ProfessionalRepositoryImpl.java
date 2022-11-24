package com.hydraulic.applyforme.repository.impl;


import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.repository.ProfessionalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Slf4j
@Repository
public class ProfessionalRepositoryImpl implements ProfessionalRepository {

    @PersistenceContext
    private EntityManager entityManager;

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
        }
        else {
            return false;
        }
    }
}
