package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.applicant.ApplicantDto;
import com.hydraulic.applyforme.model.dto.professionalprofile.ProfessionalProfileDto;
import com.hydraulic.applyforme.model.security.UserDetailsImpl;
import com.hydraulic.applyforme.service.job.ProfessionalJobProfileService;
import com.hydraulic.applyforme.util.CurrentUserUtil;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    	return service.deleteByProfileId(currentUser.getId(), profile_id);
    }

    @PutMapping("/update/{id}")
    public ProfessionalProfile update(@Validated @RequestBody ProfessionalProfileDto body, @PathVariable(name ="id") Long id) {
        return service.update(id, body);
    }


//    @PreAuthorize("hasRole('Recruiter')")
    @GetMapping("/all")
    public List<ProfessionalProfile> getAll(){
        return service.findAllJobProfiles();

    }
}
