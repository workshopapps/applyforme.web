package com.hydraulic.applyforme.model.dto;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.enums.JobLocationType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor @RequiredArgsConstructor
@Builder
public class SubmissionDto {


    private Long id;


    private Long professionalId;


    private Long applierId;

    private String jobTitle;


    private String jobLink;


    private String jobLocation;


    private String jobCompany;


    private JobLocationType jobLocationType;



    private String summary;


    private String otherComment;

    private Date createdOn;


    private Date updatedOn;
}
