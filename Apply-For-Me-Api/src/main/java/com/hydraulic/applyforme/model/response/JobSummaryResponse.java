package com.hydraulic.applyforme.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobSummaryResponse {
    private String jobTitle;
    private String jobLocation;
    private String jobCompany;

}
