package com.hydraulic.applyforme.model.dto.professionalprofile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hydraulic.applyforme.annotation.EmploymentTypeAnnotation;
import com.hydraulic.applyforme.annotation.JobLocationTypeAnnotation;
import com.hydraulic.applyforme.annotation.JobSeniorityAnnotation;
import com.hydraulic.applyforme.model.enums.EmploymentType;
import com.hydraulic.applyforme.model.enums.JobLocationType;
import com.hydraulic.applyforme.model.enums.JobSeniority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionalProfileDto {

    @NotNull(message = "{professionalProfile.jobTitle.notNull}")
    @NotBlank(message = "{professionalProfile.jobTitle.notNull}")
    @Size(min = 1, max = 400, message = "{professionalProfile.jobTitle.size}")
    @JsonProperty("job_title")
    private String profileTitle;

    @Size(min = 1, max = 400, message = "{professionalProfile.passportLink.size}")
    @JsonProperty("passport_link")
    private String passportLink;

    @NotNull(message = "{professionalProfile.resumeLink.notNull}")
    @NotBlank(message = "{professionalProfile.resumeLink.notNull}")
    @Size(min = 1, max = 400, message = "{professionalProfile.resumeLink.size}")
    @JsonProperty("resume_link")
    private String resumeLink;

    @Size(min = 1, max = 400, message = "{professionalProfile.coverLetterLink.size}")
    @JsonProperty("cover_letter_link")
    private String coverLetterLink;

    @NotNull(message = "{professionalProfile.coverLetterSubject.notNull}")
    @NotBlank(message = "{professionalProfile.coverLetterSubject.notNull}")
    @Size(min = 1, max = 400, message = "{professionalProfile.coverLetterSubject.size}")
    @JsonProperty("cover_letter_subject")
    private String cover_letter_subject;

    @NotNull(message = "{professionalProfile.coverLetterContent.notNull}")
    @NotBlank(message = "{professionalProfile.coverLetterContent.notNull}")
    @Size(min = 1, max = 5000, message = "{professionalProfile.coverLetterContent.size}")
    @JsonProperty("cover_letter_content")
    private String cover_letter_content;

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


    @Size(min = 1, max = 5000, message = "{professionalProfile.jobLocation.size}")
    @JsonProperty("job_location")
    private String jobLocation;

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

    @Size(min = 1, max = 400, message = "{professionalProfile.industry.size}")
    @JsonProperty("industry")
    private String industry;

    @JsonProperty("years_of_experience")
    private Integer yearsOfExperience = 0;

    @Size(min = 1, max = 400, message = "{professionalProfile.otherSkills.size}")
    @JsonProperty("other_skills")
    private String otherSkills;

    @Size(min = 1, max = 400, message = "{professionalProfile.otherComment.size}")
    @JsonProperty("other_comment")
    private String otherComment;

    @Size(min = 1, max = 400, message = "{professionalProfile.includedKeywords.size}")
    @JsonProperty("included_keywords")
    private String includedKeywords;
}
