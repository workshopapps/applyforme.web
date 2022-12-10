package com.hydraulic.applyforme.model.dto.applicant;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.enums.EmploymentType;
import com.hydraulic.applyforme.model.enums.JobLocationType;
import com.hydraulic.applyforme.model.enums.JobSeniority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ApplicantJobProfileDto {
    //private Long id;
    private String profileTitle;
    private Boolean mainProfile = false;
    private String passportLink;
    private String resumeLink;
    private String cover_letter;
    private String salaryRange = "0";
    private String employmentType;
    private String jobLocation;
    private String preferredJobLocationType ;
    private String jobSeniority;
    private String desiredJobTitle;
    private String industry;
    private Integer yearsOfExperience = 0;
    private String otherSkills;
    private String otherComment;
    private String includedKeywords;
    private Long professionalid;
    private Date updatedOn;
}