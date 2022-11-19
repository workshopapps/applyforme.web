package com.hydraulic.applyforme.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationSubmissionsResponse {
    private String applier;
    private String jobTitle;
    private String jobLink;
    private String jobLocation;
    private String jobCompany;
    private String jobLocationType;
    private String summary;
    private String otherComment;
    private String createdOn;
    private String updatedOn;
}
