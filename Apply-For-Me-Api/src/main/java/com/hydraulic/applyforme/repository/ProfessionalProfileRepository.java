package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.applicant.ApplicantJobProfileDto;

import java.util.List;

public interface ProfessionalProfileRepository {
    ProfessionalProfile getOne(Long id);
    boolean remove(Long id);
    ProfessionalProfile updateOne(ProfessionalProfile body);
    int updateProfile(ApplicantJobProfileDto body);
}
