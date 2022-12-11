package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.SalaryRange;
import com.hydraulic.applyforme.model.dto.salaryrange.SalaryRangeDto;
import com.hydraulic.applyforme.model.dto.salaryrange.DeleteManySalaryRangeDto;
import com.hydraulic.applyforme.service.SalaryRangeService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "salary-range",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class SalaryRangeController {

    private SalaryRangeService service;

    public SalaryRangeController(SalaryRangeService service) {
        this.service = service;
    }

    @GetMapping("/entries")
    public List<SalaryRange> findAll(@RequestParam(required = false, defaultValue = "1" , name = "page") Integer pageNumber) {
        return service.findAll(pageNumber);
    }

    @GetMapping("/entries/all")
    public List<SalaryRange> findAll() {
        return service.findAll();
    }

    @GetMapping("/detail/{id}")
    public SalaryRange findOne(@PathVariable(name ="id") Long id) {
        return service.findOne(id);
    }

    @PostMapping("/save")
    public SalaryRange save(@Validated @RequestBody SalaryRangeDto body) {
        return service.save(body);
    }

    @PutMapping("/update/{id}")
    public SalaryRange update(@Validated @RequestBody SalaryRangeDto body, @PathVariable(name ="id") Long id) {
        return service.update(id, body);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/remove/many")
    public boolean deleteMany(@Validated @RequestBody DeleteManySalaryRangeDto body) {
        return service.deleteMany(body);
    }

    @PutMapping("/remove/all")
    public boolean deleteAll() {
        return service.deleteAll();
    }
}
