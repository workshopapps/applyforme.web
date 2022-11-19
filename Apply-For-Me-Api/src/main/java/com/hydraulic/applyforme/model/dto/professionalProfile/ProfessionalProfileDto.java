package com.hydraulic.applyforme.model.dto.professionalProfile;

import com.hydraulic.applyforme.model.enums.EmploymentType;
import com.hydraulic.applyforme.model.enums.JobLocationType;
import com.hydraulic.applyforme.model.enums.JobSeniority;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalProfileDto {

    @NotNull(message = "Profile title cannot be null")
    private String profileTitle;

    @NotNull(message = "Main profile title cannot be null")
    private Boolean mainProfile;

    private String passportLink;

    private String resumeLink;

    private String cover_letter;

    private String salaryRange;

    private EmploymentType employmentType;

    private String jobLocation;

    private JobLocationType preferredJobLocationType;

    private JobSeniority jobSeniority;

    private String desiredJobTitle;

    private String industry;

    private Integer yearsOfExperience;

    private String otherSkills;

    private String otherComment;

    private String includedKeywords;
}
