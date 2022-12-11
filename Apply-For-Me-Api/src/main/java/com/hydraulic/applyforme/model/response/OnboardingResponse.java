package com.hydraulic.applyforme.model.response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hydraulic.applyforme.annotation.EmploymentTypeAnnotation;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.enums.EmploymentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OnboardingResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String profileTitle;
    private String jobLocation;
    private String salaryRange = "0";
    private String employmentType;
    private Integer yearsOfExperience = 0;
    private String onBoardToken;
}
