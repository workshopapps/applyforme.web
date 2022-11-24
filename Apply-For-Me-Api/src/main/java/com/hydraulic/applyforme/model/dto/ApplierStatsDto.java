package com.hydraulic.applyforme.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ApplierStatsDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String currentJobTitle;
    private Date createdOn;
}
