package com.hydraulic.applyforme.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.enums.JobLocationType;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicantJobs {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("professional_id")
    private Professional professional;

    @JsonProperty("applier_id")
    private Applier applier;

    @JsonProperty("job_title")
    private String jobTitle;

    @JsonProperty("job_link")
    private String jobLink;

    @JsonProperty("job_location")
    private String jobLocation;

    @JsonProperty("job_company")
    private String jobCompany;

    @JsonProperty("job_location_type")
    private JobLocationType jobLocationType;

    @JsonProperty("summary")
    private String summary;

    @JsonProperty("other_comment")
    private String otherComment;


    @JsonProperty("professional_profile_id")
    private ProfessionalProfile professionalProfile;

    @JsonProperty("created_on")
    private Date createdOn;

    @JsonProperty("updated_on")
    private Date updatedOn;
}
