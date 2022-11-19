package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.professionalProfile.ProfessionalProfileDto;

import com.hydraulic.applyforme.service.ProfessionalProfileService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(
        value = "profile",
        produces = {MediaType.APPLICATION_JSON_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE}
)

public class ProfessionalProfileController {

    private final ProfessionalProfileService service;

    public ProfessionalProfileController(ProfessionalProfileService service){
        this.service = service;
    }

    @PostMapping("/add-professional-profile")
    public ProfessionalProfile saveProfile(@Validated @RequestBody ProfessionalProfileDto professionalProfileDto){
        return service.createProfile(professionalProfileDto);
    }

}
