package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.exception.ApplyForMeDuplicateEntityException;
import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.repository.SuperAdminRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class SuperAdminRepositoryImpl implements SuperAdminRepository {

    private static final int DEFAULT_PAGE_SIZE = 11;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Member saveOne(Member body) {
        try {
            entityManager.persist(body);
            return body;
        }
        catch (EntityExistsException ex) {
            throw new ApplyForMeDuplicateEntityException();
        }
    }

    @Override
    public Member getOneMember(Long id) {
        return entityManager.find(Member.class, id);
    }

    @Override
    public Boolean removeMemberById(Long id) {
        try{
            Member member = entityManager.getReference(Member.class, id);
            entityManager.remove(member);
            return true;
        }
        catch (EntityNotFoundException en){
            return false;
        }
    }

    @Override
    public Member viewAdminDetails(Long id) {
        Member member = entityManager.find(Member.class, id);

        if (member == null) {
            throw new MemberNotFoundException(id);
        }
        return member;
    }

    @Override
    public List<Applier> getAllMembers() {
        String queryText = "select a from Applier a";
        TypedQuery<Applier> applyForMeQuery = entityManager.createQuery(queryText, Applier.class);
        return applyForMeQuery.getResultList();
    }


}
