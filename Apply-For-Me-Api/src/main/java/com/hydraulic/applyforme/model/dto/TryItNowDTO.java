package com.hydraulic.applyforme.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hydraulic.applyforme.annotation.EmploymentTypeAnnotation;
import com.hydraulic.applyforme.annotation.JobLocationTypeAnnotation;
import com.hydraulic.applyforme.annotation.JobSeniorityAnnotation;
import com.hydraulic.applyforme.annotation.PhoneNumber;
import com.hydraulic.applyforme.model.enums.EmploymentType;

import com.hydraulic.applyforme.model.enums.JobLocationType;
import com.hydraulic.applyforme.model.enums.JobSeniority;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TryItNowDTO {

    @JsonProperty("first_name")
    @NotNull(message = "member.firstName.notNull")
    private String firstName;

    @JsonProperty("last_name")
    @NotNull(message = "member.lastName.notNull")
    private String lastName;
    
    @JsonProperty("email_address")
    @NotNull(message = "{member.email.notNull}")
    @NotBlank(message = "{member.email.notBlank}")
    @Email(message = "{member.email.valid}")
    private String emailAddress;
    
    @JsonProperty("phone_number")
    @NotNull(message = "{member.phoneNumber.notNull}")
    @PhoneNumber
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

    @NotNull(message = "{professionalProfile.jobLocationType.notNull}")
    @NotBlank(message = "{professionalProfile.jobLocationType.notNull}")
    @JobLocationTypeAnnotation(enumClass = JobLocationType.class, message = "{professionalProfile.jobLocationType.enum}")
    @JsonProperty("job_location_type")
    private String preferredJobLocationType;

    @NotNull(message = "{professionalProfile.jobSeniority.notNull}")
    @NotBlank(message = "{professionalProfile.jobSeniority.notNull}")
    @JobSeniorityAnnotation(enumClass = JobSeniority.class, message = "{professionalProfile.jobSeniority.enum}")
    @JsonProperty("job_seniority")
    private String jobSeniority;
    
    @Size(min = 1, max = 400, message = "{professionalProfile.desiredJobTitle.size}")
    @JsonProperty("desired_job_title")
    private String desiredJobTitle;
    
    @JsonProperty("years_of_experience")
    private Integer yearsOfExperience = 0;
}
