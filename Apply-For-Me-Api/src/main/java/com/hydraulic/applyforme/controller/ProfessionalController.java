package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.SalaryRange;
import com.hydraulic.applyforme.model.dto.professional.ProfessionalDto;
import com.hydraulic.applyforme.model.dto.salaryrange.SalaryRangeDto;
import com.hydraulic.applyforme.service.ProfessionalService;
import org.springframework.data.domain.Page;
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

    public ProfessionalController(ProfessionalService service) {this.service = service;}

    @GetMapping("/entries")
    public List<Professional> findAll(@RequestParam(required = false, defaultValue = "1", name = "page") Integer pageOffset) {
        return service.findAll(pageOffset);
    }

    @GetMapping("/detail/{id}")
    public Professional findOne(@PathVariable(name ="id") Long id) {
        return service.findOne(id);
    }

    @PutMapping("/update/{id}")
    public Professional update(@Validated @RequestBody ProfessionalDto body, @PathVariable(name ="id") Long id) {
        return service.updateProfile(body, id);

    @GetMapping("/applicants/{pageNo}/{pageSize}")
    public Page<Professional> retrieveApplicants(@PathVariable int pageNo, @PathVariable int pageSize ){
        return  service.retrieveAllProfessionals(pageNo, pageSize);
    }
}

