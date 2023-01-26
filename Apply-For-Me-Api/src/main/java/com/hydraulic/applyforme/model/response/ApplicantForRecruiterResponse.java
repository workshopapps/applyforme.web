package com.hydraulic.applyforme.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicantForRecruiterResponse {

    @JsonProperty("name")
    private String name;

    @JsonProperty("mail")
    private String mail;

    @JsonProperty("plan")
    private String plan;

    @JsonProperty("applications_done")
    private Long applicationsDone;

    @JsonProperty("interviews")
    private Long interviews;
}
