package com.hydraulic.applyforme.model.dto;

import java.util.List;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.Submission;

import lombok.Data;

@Data
public class ProfessionalJobSubmissionDTO {
    
    private List<Submission> submissions;
    
    private Professional professional;
}
