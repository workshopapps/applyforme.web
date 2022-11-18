package com.hydraulic.applyforme.model.dto;

import java.util.Date;

import com.hydraulic.applyforme.model.domain.Applier;

import lombok.Data;

@Data
public class ProfessionalSubmissionResponse {

    private Applier applier;

    private String jobTitle;

    private String jobLink;

    private String otherComment;

    private Date createdOn;
}
