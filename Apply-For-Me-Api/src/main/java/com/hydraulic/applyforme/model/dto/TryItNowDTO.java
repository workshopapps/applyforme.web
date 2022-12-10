package com.hydraulic.applyforme.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hydraulic.applyforme.annotation.EmploymentTypeAnnotation;
import com.hydraulic.applyforme.model.enums.EmploymentType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TryItNowDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;
    
    @JsonProperty("email_address")
    private String emailAddress;
    
    @JsonProperty("phone_number")
    private String phoneNumber;
	
    @NotNull(message = "{professionalProfile.jobTitle.notNull}")
    @NotBlank(message = "{professionalProfile.jobTitle.notNull}")
    @Size(min = 1, max = 400, message = "{professionalProfile.jobTitle.size}")
    @JsonProperty("job_title")
    private String profileTitle;
    
    @Size(min = 1, max = 5000, message = "{professionalProfile.jobLocation.size}")
    @JsonProperty("job_location")
    private String jobLocation;
    
    @NotNull(message = "{professionalProfile.salaryRange.notNull}")
    @NotBlank(message = "{professionalProfile.salaryRange.notNull}")
    @Size(min = 1, max = 100, message = "{professionalProfile.salaryRange.size}")
    @JsonProperty("salary_range")
    private String salaryRange = "0";

    @NotNull(message = "{professionalProfile.employmentType.notNull}")
    @NotBlank(message = "{professionalProfile.employmentType.notNull}")
    @EmploymentTypeAnnotation(enumClass = EmploymentType.class, message = "{professionalProfile.employmentType.enum}")
    @JsonProperty("employment_type")
    private String employmentType;
    
    @Size(min = 1, max = 400, message = "{professionalProfile.desiredJobTitle.size}")
    @JsonProperty("desired_job_title")
    private String desiredJobTitle;
    
    @JsonProperty("years_of_experience")
    private Integer yearsOfExperience = 0;
}
