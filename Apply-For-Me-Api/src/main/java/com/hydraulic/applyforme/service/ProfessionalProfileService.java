package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.professionalProfile.ProfessionalProfileDto;

public interface ProfessionalProfileService {

    ProfessionalProfile createProfile(ProfessionalProfileDto body);
}
