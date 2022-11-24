package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.UpdatePasswordDTO;
import com.hydraulic.applyforme.repository.SuperAdminRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	public Member updatePassword(Long id, UpdatePasswordDTO password) {
		
		String query = "UPDATE Member m SET m.password = :newPassword WHERE m.id = :memberId";
		TypedQuery<Member> updatedMember = entityManager.createQuery(query, Member.class);
		updatedMember.setParameter("newPassword", password.getNewPassword());
		updatedMember.setParameter("memberId", id);
		
		return updatedMember.getSingleResult();
	}
    
}
