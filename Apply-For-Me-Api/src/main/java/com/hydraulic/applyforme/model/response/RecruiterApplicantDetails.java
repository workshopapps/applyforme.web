package com.hydraulic.applyforme.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecruiterApplicantDetails {

    @JsonProperty("name")
    private String name;

    @JsonProperty("role")
    private String role;

    @JsonProperty("joined_on")
    private Date joinedOn;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("membership_plan")
    private String membershipPlan;

    @JsonProperty("experience")
    private Long experience;

    @JsonProperty("industry")
    private String industry;

    @JsonProperty("salary_expectation")
    private String salaryExpectation;

    @JsonProperty("employement_type")
    private String employementType;

    @JsonProperty("cv")
    private String cv;

    @JsonProperty("cover_letter")
    private String coverLetter;
}
