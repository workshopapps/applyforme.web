package com.hydraulic.applyforme.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RecruiterCustomDto {

    @JsonProperty("member_id")
    private Long memberId;

    @JsonProperty("role")
    private String role;

    @JsonProperty("salary")
    private String salary;

    @JsonProperty("employement")
    private String employement;
}
