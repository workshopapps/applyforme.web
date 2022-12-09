package com.hydraulic.applyforme.model.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.dto.applicant.ApplicantResponse;
import com.hydraulic.applyforme.model.enums.EmploymentType;
import com.hydraulic.applyforme.model.enums.JobLocationType;
import com.hydraulic.applyforme.model.enums.JobSeniority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @RequiredArgsConstructor
@Builder @JsonIgnoreProperties
public class ProfessionalProfileResponse {	
	
	@JsonProperty("id")
	private Long id;
	@JsonProperty("profileTitle")
	private String profileTitle;
	@JsonProperty("mainProfile")
	private Boolean mainProfile;
	@JsonProperty("passportLink")
	private String passportLink;
	@JsonProperty("resumeLink")
	private String resumeLink;
	@JsonProperty("coverLetterLink")
	private String coverLetterLink;
	@JsonProperty("coverLetterSubject")
	private String coverLetterSubject;
	@JsonProperty("coverLetterContent")
	private String coverLetterContent;
	@JsonProperty("salaryRange")
	private String salaryRange;
	@JsonProperty("employmentType")
	private EmploymentType employmentType;
	@JsonProperty("jobLocation")
	private String jobLocation;
	@JsonProperty("preferredJobLocationType")
	private JobLocationType preferredJobLocationType;
	@JsonProperty("jobSeniority")
	private JobSeniority jobSeniority;
	@JsonProperty("desiredJobTitle")
    private String desiredJobTitle;
	@JsonProperty("industry")
    private String industry;
	@JsonProperty("yearsOfExperience")
    private Integer yearsOfExperience;
	@JsonProperty("otherSkills")
    private String otherSkills;
	@JsonProperty("otherComment")
    private String otherComment;
	@JsonProperty("includedKeywords")
    private String includedKeywords;
	@JsonProperty("professional")
    private Professional professional;
	@JsonProperty("createdOn")
    private Date createdOn;
	@JsonProperty("updatedOn")
    private Date updatedOn;
}
