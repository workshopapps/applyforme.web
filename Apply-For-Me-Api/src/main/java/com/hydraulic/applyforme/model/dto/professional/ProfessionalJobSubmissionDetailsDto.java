package com.hydraulic.applyforme.model.dto.professional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.enums.JobLocationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ProfessionalJobSubmissionDetailsDto {

    private String jobTitle;

    private String jobLink;

    private String jobLocation;

    private String jobCompany;

    private String jobLocationType;

    private String summary;

    private String otherComment;

    private Date createdOn;
}
