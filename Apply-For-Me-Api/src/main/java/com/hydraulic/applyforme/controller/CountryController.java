package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.dto.country.CountryDto;
import com.hydraulic.applyforme.model.dto.country.DeleteManyCountryDto;
import com.hydraulic.applyforme.service.CountryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "country",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
@Tag(name = "Country")
public class CountryController {

    private CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping("/entries")
    public List<Country> findAll(@RequestParam(required = false, defaultValue = "1" , name = "page") Integer pageNumber) {
        return service.findAll(pageNumber);
    }

    @GetMapping("/entries/all")
    public List<Country> findAll() {
        return service.findAll();
    }

    @GetMapping("/detail/{id}")
    public Country findOne(@PathVariable(name ="id") Long id) {
        return service.findOne(id);
    }

    @PostMapping("/save")
    public Country save(@Validated @RequestBody CountryDto body) {
        return service.save(body);
    }

    @PutMapping("/update/{id}")
    public Country update(@Validated @RequestBody CountryDto body, @PathVariable(name ="id") Long id) {
        return service.update(id, body);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/remove/many")
    public boolean deleteMany(@Validated @RequestBody DeleteManyCountryDto body) {
        return service.deleteMany(body);
    }

    @PutMapping("/remove/all")
    public boolean deleteAll() {
        return service.deleteAll();
    }
}
