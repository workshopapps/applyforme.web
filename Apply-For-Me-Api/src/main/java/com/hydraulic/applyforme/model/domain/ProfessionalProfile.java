package com.hydraulic.applyforme.model.domain;

import com.hydraulic.applyforme.model.enums.EmploymentType;
import com.hydraulic.applyforme.model.enums.JobLocationType;
import com.hydraulic.applyforme.model.enums.JobSeniority;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * In the system, a developer or designer or professional can create and have multiple
 * profile which can be suited to different roles or jobs he or she is
 * interested in. The professional should be given the flexibility to upload
 * new details like passport or cv or cover letter tailored to the job title of interest.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="professional_profile")
public class ProfessionalProfile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * This is used to identify the profile that an applier can use to apply and submit a job application that is tailored or suitable to the professional.
     */
    @Column(name ="profile_title", nullable = false)
    private String profileTitle;

    /**
     * This attribute or field is useful when a developer or designer or any other professional wants to create another profile.
     * If this profile is set as the main profile, anytime a new profile is about to be created; the details or data in the profile record set as
     * main will be used to prepopulate the fields to be used for the new profile to be persisted or saved or created.
     */
    @Column(name = "main_profile")
    private Boolean mainProfile = false;

    @Column(name ="passport_link")
    private String passportLink;

    @Column(name ="resume_link")
    private String resumeLink;

    @Column(name ="cover_letter_link")
    private String coverLetterLink;

    @Column(name ="cover_letter_subject")
    private String coverLetterSubject;

    @Column(name ="cover_letter_content")
    private String coverLetterContent;

    @Column(name = "salary_range")
    private String salaryRange = "0";

    @Column(name = "employment_type")
    @Enumerated(EnumType.STRING)
    private EmploymentType employmentType = EmploymentType.FULL_TIME;

    @Column(name ="job_location")
    private String jobLocation;

    @Column(name ="preferred_job_location_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private JobLocationType preferredJobLocationType = JobLocationType.ONSITE;

    @Column(name ="job_seniority", nullable = false)
    @Enumerated(EnumType.STRING)
    private JobSeniority jobSeniority = JobSeniority.TRAINEE;

    @Column(name ="desired_job_title")
    private String desiredJobTitle;

    @Column(name ="industry")
    private String industry;

    @Column(name ="years_of_experience")
    private Integer yearsOfExperience = 0;

    @Column(name ="other_skills")
    private String otherSkills;

    @Column(name ="other_comment")
    private String otherComment;

    @Column(name ="included_keywords")
    private String includedKeywords;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name ="professional_id")
    private Professional professional;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", updatable = false, nullable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;
}
