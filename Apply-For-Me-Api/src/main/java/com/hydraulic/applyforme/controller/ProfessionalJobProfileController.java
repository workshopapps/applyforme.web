package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.professionalprofile.ProfessionalProfileDto;
import com.hydraulic.applyforme.service.job.ProfessionalJobProfileService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "job-profile",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class ProfessionalJobProfileController {

    private final ProfessionalJobProfileService service;

    public ProfessionalJobProfileController(ProfessionalJobProfileService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ProfessionalProfile save(@Validated @RequestBody ProfessionalProfileDto body) {
        return service.save(body);
    }
}
