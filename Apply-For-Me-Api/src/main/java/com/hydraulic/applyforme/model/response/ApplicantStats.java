package com.hydraulic.applyforme.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicantStats {

    @JsonProperty(value = "total_applications")
    private Long totalApplications;

    @JsonProperty(value = "completed_interviews")
    private Long completedInterviews;

    @JsonProperty(value = "active_applications")
    private Long activeApplications;
}
