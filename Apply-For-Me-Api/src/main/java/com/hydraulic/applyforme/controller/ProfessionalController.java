package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.dto.professional.ApplicantDto;
import com.hydraulic.applyforme.service.impl.ProfessionalServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/applicant")
@RequiredArgsConstructor
public class ProfessionalController {

   private final ProfessionalServiceImpl professionalService;
    @PostMapping("/add")
    public String addApplicant(@RequestBody ApplicantDto body){

        return professionalService.addApplicant(body);
    }

}
