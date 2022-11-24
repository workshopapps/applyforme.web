package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @GetMapping("/entries/{id}")
    public Professional findOne(@PathVariable(name = "id") Long id) {return service.findOne(id);}
}
