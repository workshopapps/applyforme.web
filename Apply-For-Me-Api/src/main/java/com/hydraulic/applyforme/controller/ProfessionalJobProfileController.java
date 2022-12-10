package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.professionalprofile.ProfessionalProfileDto;
import com.hydraulic.applyforme.service.job.ProfessionalJobProfileService;
import com.hydraulic.applyforme.util.CurrentUserUtil;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @PreAuthorize("hasRole('Professional')")
    @PostMapping("/save")
    public ProfessionalProfile save(@Validated @RequestBody ProfessionalProfileDto body) {
        var currentUser = CurrentUserUtil.getCurrentUser();
        return service.save(currentUser.getId(), body);
    }

    @PreAuthorize("hasRole('Professional')")
    @DeleteMapping("/remove")
        public boolean delete(Long id){
        var currentUser = CurrentUserUtil.getCurrentUser();
        return service.removeProfile(currentUser.getId());
        }
}
