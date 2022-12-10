package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.dto.TryItNowDTO;
import com.hydraulic.applyforme.model.response.OnboardingResponse;

public interface OnboardingService {

	public OnboardingResponse onboard(TryItNowDTO body);
}
