package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.TryItNowDTO;

public interface OnboardingRepository {

	Member onboardMember(TryItNowDTO body);
	ProfessionalProfile onboardProfile(TryItNowDTO body);
}
