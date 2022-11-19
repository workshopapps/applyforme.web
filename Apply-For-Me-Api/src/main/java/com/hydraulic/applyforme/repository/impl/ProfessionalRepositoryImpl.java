package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.repository.ProfessionalRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProfessionalRepositoryImpl implements ProfessionalRepository {

    private static final int DEFAULT_PAGE_SIZE = 11;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Professional> getAll(Integer pageOffset) {
        String queryString = "select t1.desiredJobTitle, t1.preferredJobLocationType, t1.yearsOfExperience," +
                "t1.salaryRange, t3.firstName, t3.lastName from ProfessionalProfile t1, Professional t2, " +
                "Member t3 order by t3.createdOn desc";
        TypedQuery<Professional> professionalQuery = entityManager.createQuery(queryString, Professional.class);

        professionalQuery.setFirstResult((pageOffset-1) * DEFAULT_PAGE_SIZE);
        professionalQuery.setMaxResults(DEFAULT_PAGE_SIZE);
        return professionalQuery.getResultList();
    }
}
