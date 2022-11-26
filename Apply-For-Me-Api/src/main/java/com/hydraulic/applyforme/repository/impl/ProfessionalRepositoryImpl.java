package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.repository.ProfessionalRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProfessionalRepositoryImpl implements ProfessionalRepository {

    private static final int DEFAULT_PAGE_SIZE = 11;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Professional> getAll(Integer pageOffset) {
        String queryString = "select p from Professional p order by p.member.updatedOn desc";
        TypedQuery<Professional> professionalQuery = entityManager.createQuery(queryString, Professional.class);

        professionalQuery.setFirstResult((pageOffset-1) * DEFAULT_PAGE_SIZE);
        professionalQuery.setMaxResults(DEFAULT_PAGE_SIZE);
        return professionalQuery.getResultList();
    }

    @Override
    public Professional getOne(Long id) {return entityManager.find(Professional.class, id);
    }
}
