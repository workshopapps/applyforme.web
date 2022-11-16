package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.ApplyForMe;
import com.hydraulic.applyforme.model.dto.ApplyForMeDto;
import com.hydraulic.applyforme.service.ApplyForMeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(
        value = "apply",
        produces = { MediaType.APPLICATION_JSON_VALUE },
        consumes = { MediaType.APPLICATION_JSON_VALUE }
)
public class ApplyForMeController {

    private ApplyForMeService service;

    public ApplyForMeController(ApplyForMeService service) {
        this.service = service;
    }

    @GetMapping("/entries")
    public List<ApplyForMe> findAll(@RequestParam(required = false, defaultValue = "1" , name = "page") Integer pageNumber) {
        return service.findAll(pageNumber);
    }

    @GetMapping("/detail/{id}")
    public ApplyForMe findOne(@PathVariable(name ="id") Long id) {
        return service.findOne(id);
    }

    @PostMapping("/save")
    public ApplyForMe save(@Valid @RequestBody ApplyForMeDto body) {
        return service.save(body);
    }

    @PutMapping("/update/{id}")
    public ApplyForMe update(@Valid @RequestBody ApplyForMeDto body, @PathVariable(name ="id") Long id) {
        return service.update(id, body);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
