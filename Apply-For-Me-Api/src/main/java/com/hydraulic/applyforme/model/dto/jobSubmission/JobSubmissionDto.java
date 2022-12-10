package com.hydraulic.applyforme.model.dto.jobSubmission;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hydraulic.applyforme.model.domain.Country;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobSubmissionDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("applicants_name")
    private String applicantsName;

    @JsonProperty("job_role")
    private String jobRole;

    @JsonProperty("membership_plan")
    private String membershipPlan ;

    @JsonProperty("company_name")
    private String companyName;

}
