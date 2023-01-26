package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.repository.RecruiterRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RecruiterRepositoryImpl implements RecruiterRepository {

    private static final int DEFAULT_PAGE_SIZE = 11;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Member getMyDetailsById(Long id) {
        Member recruiter = entityManager.find(Member.class, id);

        if (recruiter ==  null){
            throw new MemberNotFoundException(id);
        }
        return recruiter;
    }
}
