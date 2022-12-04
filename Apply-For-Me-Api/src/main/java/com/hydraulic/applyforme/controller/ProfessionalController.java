package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.dto.professional.ProfessionalDto;
import com.hydraulic.applyforme.model.dto.professional.ProfessionalJobSubmissionDetailsDto;
import com.hydraulic.applyforme.service.ProfessionalService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "professional",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class ProfessionalController {

    private ProfessionalService service;

    public ProfessionalController(ProfessionalService service) {
        this.service = service;
    }

    @GetMapping("/entries")
    public List<Professional> findAll(@RequestParam(required = false, defaultValue = "1", name = "page") Integer pageOffset) {
        return service.findAll(pageOffset);
    }

    @GetMapping("/detail/{id}")
    public Professional findOne(@PathVariable(name ="id") Long id) {
        return service.findOne(id);
    }

    @PutMapping("/update/{id}")
    public Professional update(@Validated @PathVariable(name ="id") Long id ,@RequestBody ProfessionalDto body) {
//        UserDetailsImpl userDetails = CurrentUserUtil.getCurrentUser();
//        Long id = userDetails.get
//
//        Id();
//        System.out.println("userDetails.getId(): " + id);
        return service.updateProfessional(body,id);
    }

    @GetMapping("/jobSubmissions/{id}")
    public List<ProfessionalJobSubmissionDetailsDto> findAll(@Validated @PathVariable(name ="id") Long id ) {
        return service.getJobsSubmissionDetails(id);
    }
}
