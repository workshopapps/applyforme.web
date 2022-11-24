package com.hydraulic.applyforme.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.repository.SuperAdminRepository;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.repository.SuperAdminRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class SuperAdminRepositoryImpl implements SuperAdminRepository {

    private static final int DEFAULT_PAGE_SIZE = 11;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Member getOneMember(Long id) {
        return entityManager.find(Member.class, id);
    }

	@Override
	public Member updatePassword(Long id, String newPassword) {
		String query = "UPDATE Member m SET m.password = :newPassword WHERE m.id = :memberId";
		TypedQuery<Member> updatedMember = entityManager.createQuery(query, Member.class);
		updatedMember.setParameter("newPassword", newPassword);
		updatedMember.setParameter("memberId", id);
		return updatedMember.getSingleResult();
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
        return entityManager.find(Member.class, id);
//        Query query = entityManager.createQuery("select m from Member m where m.id in (:ids)");
//        query.setParameter("ids", id);
//        return query.executeUpdate() > 0;
    }
}
