package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.JobTitle;
import com.hydraulic.applyforme.model.dto.jobtitle.DeleteManyJobTitleDto;
import com.hydraulic.applyforme.model.dto.jobtitle.JobTitleDto;
import com.hydraulic.applyforme.service.JobTitleService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "job-title",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class JobTitleController {


    private JobTitleService service;

    public JobTitleController(JobTitleService service) {
        this.service = service;
    }

    @GetMapping("/entries")
    public List<JobTitle> findAll(@RequestParam(required = false, defaultValue = "1" , name = "page") Integer pageNumber) {
        return service.findAll(pageNumber);
    }

    @GetMapping("/entries/all")
    public List<JobTitle> findAll() {
        return service.findAll();
    }

    @GetMapping("/detail/{id}")
    public JobTitle findOne(@PathVariable(name ="id") Long id) {
        return service.findOne(id);
    }

    @PostMapping("/save")
    public JobTitle save(@Validated @RequestBody JobTitleDto body) {
        return service.save(body);
    }

    @PutMapping("/update/{id}")
    public JobTitle update(@Validated @RequestBody JobTitleDto body, @PathVariable(name ="id") Long id) {
        return service.update(id, body);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/remove/many")
    public boolean deleteMany(@Validated @RequestBody DeleteManyJobTitleDto body) {
        return service.deleteMany(body);
    }

    @PutMapping("/remove/all")
    public boolean deleteAll() {
        return service.deleteAll();
    }
}
