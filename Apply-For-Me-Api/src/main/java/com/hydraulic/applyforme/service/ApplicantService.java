package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.applicant.ApplicantJobProfileDto;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;

public interface ApplicantService {

    ApplyForMeResponse getApplicationList(int pageNo, int pageSize, String sortBy, String sortDir);
    ApplicantJobProfileDto updateJobProfile(ApplicantJobProfileDto applicantJobProfileDto, Long id);
    ApplicantJobProfileDto updateProfessionalJobProfile(ApplicantJobProfileDto body, Long id);
}
