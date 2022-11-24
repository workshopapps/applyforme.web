package com.hydraulic.applyforme.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.repository.SuperAdminRepository;

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
}
