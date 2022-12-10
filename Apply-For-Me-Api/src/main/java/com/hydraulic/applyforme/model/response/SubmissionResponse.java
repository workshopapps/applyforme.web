package com.hydraulic.applyforme.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionResponse {

    @JsonProperty("professional_profile")
    private Long professionalProfile;

    @JsonProperty("professional_id")
    private Long professionalId;

    @JsonProperty("member_id")
    private Long memberId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("job_title")
    private String jobTitle;

    @JsonProperty("plan")
    private String plan;

    @JsonProperty("salary")
    private String salary;

    @JsonProperty("job_type")
    private String jobType;

    @JsonProperty("total_applications")
    private Long totalApplications;

    @JsonProperty("applied_job")
    private Long appliedJob;
}
