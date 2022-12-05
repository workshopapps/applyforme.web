package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.ApplyForMe;
import com.hydraulic.applyforme.repository.ApplierRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class ApplierRepositoryImpl implements ApplierRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Applier> getAll(Integer pageOffset) {
        return null;
    }

    @Override
    public Applier getOne(Long id) {
        return entityManager.find(Applier.class, id);
    }

    @Override
    public Applier getRef(Long id) {
        try {
            return entityManager.getReference(Applier.class, id);
        }
        catch (EntityNotFoundException ex) {
            return null;
        }
    }

    @Override
    public Applier saveOne(Applier body) {
        return null;
    }

    @Override
    public Applier updateOne(ApplyForMe body) {
        return null;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }

    @Override
    public boolean removeMany(List<Long> ids) {
        return false;
    }

    @Override
    public boolean removeAll() {
        return false;
    }
}
