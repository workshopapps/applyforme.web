package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.repository.SuperAdminStatRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Slf4j
@Repository
public class SuperAdminStatRepositoryImpl implements SuperAdminStatRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long getAllSubmissions() {
        String queryText = "select count(jb) from Submission jb";
        TypedQuery<Long> allSubmissionsQuery = entityManager.createQuery(queryText, Long.class);
        return allSubmissionsQuery.getSingleResult();
    }

    @Override
    public Long getAllUsers() {
        String queryText = "select count(m) from Member m";
        TypedQuery<Long> allMembersQuery = entityManager.createQuery(queryText, Long.class);
        return allMembersQuery.getSingleResult();
    }
}