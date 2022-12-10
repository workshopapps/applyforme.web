package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.professionalprofile.ProfessionalProfileDto;
import com.hydraulic.applyforme.model.security.UserDetailsImpl;
import com.hydraulic.applyforme.service.job.ProfessionalJobProfileService;
import com.hydraulic.applyforme.util.CurrentUserUtil;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PreAuthorize("hasRole('Professional')")
    @PostMapping("/save")
    public ProfessionalProfile save(@Validated @RequestBody ProfessionalProfileDto body) {
        var currentUser = CurrentUserUtil.getCurrentUser();
        return service.save(currentUser.getId(), body);
    }
    
    @DeleteMapping("/delete/{id}")
    public boolean deleteProfessionalJobProfile(@PathVariable("id") Long profile_id) {
    	UserDetailsImpl currentUser = CurrentUserUtil.getCurrentUser();
    	service.deleteByProfileId(currentUser.getId(), profile_id);
    	return true;
    }
}
