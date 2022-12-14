package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.exception.MemberDuplicateEntityException;
import com.hydraulic.applyforme.repository.MemberRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Repository
public class MemberRepositoryImpl implements MemberRepository {

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
    public Member fetchOne(Long id) {
    	String q = "select m from Applier m where m.member.id = :id";
    	TypedQuery<Member> query = entityManager.createQuery(q, Member.class);
    	query.setParameter("id", id); 
    	return query.getSingleResult();
    }

    @Override
    public Member getRef(Long id) {
        try {
            return entityManager.getReference(Member.class, id);
        }
        catch (EntityNotFoundException ex) {
            return null;
        }
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
    public boolean updateOne(Member body) {
    	entityManager.merge(body);
        return true;
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
    
    public void deleteMemberRole() {
    	
    }

    @Override
    public Long getAllSubmissions(Long id, Date startDate, Date endDate) {
        String queryText = "select count(jb) from Submission jb where jb.professional.member.id = :id";
        TypedQuery<Long> total = entityManager.createQuery(queryText, Long.class);

        if (startDate != null && endDate != null) {
            queryText = "select count(jb) from Submission jb where jb.createdOn between :startDate and :endDate AND jb.professional.member.id = :id";
            total = entityManager.createQuery(queryText, Long.class);
            total.setParameter("startDate", startDate, TemporalType.TIMESTAMP);
            total.setParameter("endDate", endDate, TemporalType.TIMESTAMP);
        }

        total.setParameter("id" , id);

        return total.getSingleResult();
    }
    @Override
    public Long getAllProfiles(Long id, Date startDate, Date endDate) {
        String queryText = "select count(pp) from ProfessionalProfile pp where pp.professional.member.id = :id";
        TypedQuery<Long> total = entityManager.createQuery(queryText, Long.class);

        if (startDate != null && endDate != null) {
            queryText = "select count(pp) from ProfessionalProfile pp where pp.createdOn between :startDate and :endDate AND pp.professional.member.id = :id";
            total = entityManager.createQuery(queryText, Long.class);
            total.setParameter("startDate", startDate, TemporalType.TIMESTAMP);
            total.setParameter("endDate", endDate, TemporalType.TIMESTAMP);
        }
        total.setParameter("id" , id);

        return total.getSingleResult();
    }
}

