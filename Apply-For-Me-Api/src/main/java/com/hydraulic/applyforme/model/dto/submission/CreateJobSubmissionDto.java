package com.hydraulic.applyforme.model.dto.submission;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateJobSubmissionDto {

    @NotNull(message = "{jobSubmission.professional.notNull}")
    @JsonProperty("professional_id")
    private Long professionalId;

    @NotNull(message = "{jobSubmission.applier.notNull}")
    @JsonProperty("applier_id")
    private Long applierId;

    @NotNull(message = "{jobSubmission.professionalProfile.notNull}")
    @JsonProperty("professional_profile_id")
    private Long professionalProfileId;

    @NotNull(message = "{jobSubmission.jobTitle.notNull}")
    @NotBlank(message = "{jobSubmission.jobTitle.notNull}")
    @Size(min = 1, max = 400, message = "{jobSubmission.jobTitle.size}")
    @JsonProperty("job_title")
    private String jobTitle;

    @NotNull(message = "{jobSubmission.jobLink.notNull}")
    @NotBlank(message = "{jobSubmission.jobLink.notNull}")
    @Size(min = 1, max = 400, message = "{jobSubmission.jobLink.size}")
    @JsonProperty("job_link")
    private String jobLink;


    @Size(min = 1, max = 400, message = "{jobSubmission.jobLocation.size}")
    @JsonProperty("job_location")
    private String jobLocation;

    @Size(min = 1, max = 400, message = "{jobSubmission.jobCompany.size}")
    @JsonProperty("job_company")
    private String jobCompany;

    @Size(min = 1, max = 3000, message = "{jobSubmission.summary.size}")
    @JsonProperty("summary")
    private String summary;

    @Size(min = 1, max = 400, message = "{jobSubmission.otherComment.size}")
    @JsonProperty("other_comment")
    private String otherComment;
}
