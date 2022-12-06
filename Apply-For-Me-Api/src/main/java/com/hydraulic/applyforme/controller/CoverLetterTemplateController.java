package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.CoverLetterTemplate;
import com.hydraulic.applyforme.model.dto.coverlettertemplate.CoverLetterTemplateDto;
import com.hydraulic.applyforme.model.dto.coverlettertemplate.DeleteManyCoverLetterTemplateDto;
import com.hydraulic.applyforme.service.impl.CoverLetterTemplateServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "cover-letter-template",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class CoverLetterTemplateController {

    private CoverLetterTemplateServiceImpl service;

    public CoverLetterTemplateController(CoverLetterTemplateServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/entries")
    public List<CoverLetterTemplate> findAll(@RequestParam(required = false, defaultValue = "1" , name = "page") Integer pageNumber) {
        return service.findAll(pageNumber);
    }

    @GetMapping("/entries/all")
    public List<CoverLetterTemplate> findAll() {
        return service.findAll();
    }

    @GetMapping("/detail/{id}")
    public CoverLetterTemplate findOne(@PathVariable(name ="id") Long id) {
        return service.findOne(id);
    }

    @PostMapping("/save")
    public CoverLetterTemplate save(@Validated @RequestBody CoverLetterTemplateDto body) {
        return service.save(body);
    }

    @PutMapping("/update/{id}")
    public CoverLetterTemplate update(@Validated @RequestBody CoverLetterTemplateDto body, @PathVariable(name ="id") Long id) {
        return service.update(id, body);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/remove/many")
    public boolean deleteMany(@Validated @RequestBody DeleteManyCoverLetterTemplateDto body) {
        return service.deleteMany(body);
    }

    @PutMapping("/remove/all")
    public boolean deleteAll() {
        return service.deleteAll();
    }
}
