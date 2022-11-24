package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.repository.UpdateMemberRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

@Repository
public class UpdateMemberRepositoryImpl implements UpdateMemberRepository {


    @PersistenceContext
    private EntityManager entityManager;

    public Member getOne(Long id) {
        return entityManager.find(Member.class, id);
    }

    public Member updateOne(Member body) {
        return entityManager.merge(body);
    }
}
