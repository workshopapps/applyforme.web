package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        value = "professional",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class ProfessionalController {

    private ProfessionalService service;

    public ProfessionalController(ProfessionalService service) {this.service = service;}

    @GetMapping("/entries/appliers")
    public List<Professional> findAll(@RequestParam(required = false, defaultValue = "1", name = "page") Integer pageOffset) {
        return service.findAll(pageOffset);
    }
}
