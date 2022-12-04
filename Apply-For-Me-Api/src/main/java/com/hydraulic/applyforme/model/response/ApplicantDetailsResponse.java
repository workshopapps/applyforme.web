package com.hydraulic.applyforme.model.response;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Professional;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicantDetailsResponse {

    private Member membership;
    private Professional professional;
    private long totalSubmissions;
    private long totalProfessionalProfile;
}
