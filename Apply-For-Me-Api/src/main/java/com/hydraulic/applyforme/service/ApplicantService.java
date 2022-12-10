package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.dto.applicant.ApplicantDto;

import com.hydraulic.applyforme.model.domain.Member;

import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;

public interface ApplicantService {

    Professional update(Long id, ApplicantDto applicantDto);

    ApplyForMeResponse getApplicationList(int pageNo, int pageSize, String sortBy, String sortDir);
        Member getDetails(Long id);

        Member updateAvatar(Long applicantId, String newProfilePicture);

}
