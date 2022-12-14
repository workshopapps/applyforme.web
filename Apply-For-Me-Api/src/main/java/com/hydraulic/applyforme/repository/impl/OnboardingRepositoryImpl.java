package com.hydraulic.applyforme.repository.impl;



import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.TryItNowDTO;
import com.hydraulic.applyforme.repository.OnboardingRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class OnboardingRepositoryImpl implements OnboardingRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Member onboardMember(TryItNowDTO body) {
		
		Member member = new Member();
		
		
		return null;
	}

	@Override
	public ProfessionalProfile onboardProfile(TryItNowDTO body) {
		// TODO Auto-generated method stub
		return null;
	}

}
