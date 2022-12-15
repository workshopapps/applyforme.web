package com.hydraulic.applyforme.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruiterStats {

    @JsonProperty("total_applications")
    private Long totalApplications;

    @JsonProperty("applied_jobs")
    private Long appliedJobs;
}
