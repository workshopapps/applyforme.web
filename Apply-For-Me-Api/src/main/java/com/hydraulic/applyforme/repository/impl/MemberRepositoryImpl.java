package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.domain.Member;
<<<<<<< HEAD
import com.hydraulic.applyforme.model.exception.CountryDuplicateEntityException;
import com.hydraulic.applyforme.model.exception.MemberDuplicateEntityException;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
=======
import com.hydraulic.applyforme.repository.MemberRepository;
>>>>>>> origin/feat/BE-22-add-applicant-revision
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;


@Repository
public class MemberRepositoryImpl implements MemberRepository {
<<<<<<< HEAD

=======
>>>>>>> origin/feat/BE-22-add-applicant-revision
    private static final int DEFAULT_PAGE_SIZE = 11;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Member> getAll() {
        String queryText = "select m from Member m order by m.updatedOn desc";
        TypedQuery<Member> applyForMeQuery = entityManager.createQuery(queryText, Member.class);
        return applyForMeQuery.getResultList();
    }

    @Override
    public List<Member> getAll(Integer pageOffset) {
        String queryText = "select m from Member m order by m.updatedOn desc";
        TypedQuery<Member> applyForMeQuery = entityManager.createQuery(queryText, Member.class);

        applyForMeQuery.setFirstResult((pageOffset - 1) * DEFAULT_PAGE_SIZE);
        applyForMeQuery.setMaxResults(DEFAULT_PAGE_SIZE);
        return applyForMeQuery.getResultList();
    }

    @Override
    public Member getOne(Long id) {
        return entityManager.find(Member.class, id);
    }


    @Override
    public Member saveOne(Member body) {
        try {
            entityManager.persist(body);
            return body;
        }
        catch (EntityExistsException ex) {
            throw new MemberDuplicateEntityException();
        }
    }

    @Override
    public Member updateOne(Member body) {
        return entityManager.merge(body);
    }

    @Override
    public boolean remove(Long id) {
        try {
            Member member = entityManager.getReference(Member.class, id);
            entityManager.remove(member);
            return true;
        }
        catch (EntityNotFoundException ex) {
            return false;
        }
    }

    @Override
    public boolean removeMany(List<Long> ids) {
        Query query = entityManager.createQuery("delete from Member m where m.id in (:ids)");
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
        Query query = entityManager.createQuery("delete from Member");
        if (query.executeUpdate() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

}

