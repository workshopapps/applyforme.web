package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.TryItNowDTO;
import com.hydraulic.applyforme.model.dto.admin.NewPasswordDto;
import com.hydraulic.applyforme.model.dto.admin.UpdatePasswordDto;
import com.hydraulic.applyforme.model.response.OnboardingResponse;

public interface OnboardingService {

	OnboardingResponse onboard(TryItNowDTO body);
	Member changePassword(String onboardToken, NewPasswordDto body);
}
