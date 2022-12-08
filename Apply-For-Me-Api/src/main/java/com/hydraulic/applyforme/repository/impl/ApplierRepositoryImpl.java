package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.ApplyForMe;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.repository.ApplierRepository;
import com.hydraulic.applyforme.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;
@Repository
public class ApplierRepositoryImpl implements ApplierRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private MemberRepository memberRepostity;
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
//    	Member member = memberRepostity.fetchOne(id);
    	
    	String query = "select a from Applier a where a.member.id = :id";
    	TypedQuery<Applier> applier = entityManager.createQuery(query, Applier.class);
    	applier.setParameter("id", id);
    	Applier singleResult = applier.getSingleResult();
    	
    	if(singleResult == null) {
    		throw new MemberNotFoundException(id);
    	}
    	entityManager.remove(singleResult);  
    	
        return true;
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
