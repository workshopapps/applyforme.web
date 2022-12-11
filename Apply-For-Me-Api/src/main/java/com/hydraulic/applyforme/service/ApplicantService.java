package com.hydraulic.applyforme.service;

<<<<<<< HEAD
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.applicant.ApplicantJobProfileDto;
=======
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.dto.applicant.ApplicantDto;

import com.hydraulic.applyforme.model.domain.Member;

>>>>>>> d1209ce9e517735fb2e20059e2fb0d05cea48f05
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;

public interface ApplicantService {

    Professional update(Long id, ApplicantDto applicantDto);

    ApplyForMeResponse getApplicationList(int pageNo, int pageSize, String sortBy, String sortDir);
<<<<<<< HEAD
    ApplicantJobProfileDto updateJobProfile(ApplicantJobProfileDto applicantJobProfileDto, Long id);
    ApplicantJobProfileDto updateProfessionalJobProfile(ApplicantJobProfileDto body, Long id);
=======
        Member getDetails(Long id);

>>>>>>> d1209ce9e517735fb2e20059e2fb0d05cea48f05
}
