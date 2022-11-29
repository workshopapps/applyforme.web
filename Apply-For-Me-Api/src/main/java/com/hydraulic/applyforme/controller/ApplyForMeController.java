package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.ApplyForMe;
import com.hydraulic.applyforme.model.dto.applyforme.ApplyForMeDto;
import com.hydraulic.applyforme.model.dto.applyforme.DeleteManyApplyForMeDto;
import com.hydraulic.applyforme.model.response.ApplierJobSubmissionTotalResponse;
import com.hydraulic.applyforme.service.ApplyForMeService;
import com.hydraulic.applyforme.util.CurrentUserUtil;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(
        value = "apply",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class ApplyForMeController {

    private ApplyForMeService service;

    public ApplyForMeController(ApplyForMeService service) {
        this.service = service;
    }

    @GetMapping("/entries")
    @PreAuthorize("hasAnyRole('Recruiter')")
    public List<ApplyForMe> findAll(@RequestParam(required = false, defaultValue = "1" , name = "page") Integer pageNumber) {
        return service.findAll(pageNumber);
    }

    @GetMapping("/detail/{id}")
    public ApplyForMe findOne(@PathVariable(name ="id") Long id) {
        return service.findOne(id);
    }

    @PostMapping("/save")
    public ApplyForMe save(@Validated @RequestBody ApplyForMeDto body) {
        return service.save(body);
    }

    @PutMapping("/update/{id}")
    public ApplyForMe update(@Validated @RequestBody ApplyForMeDto body, @PathVariable(name ="id") Long id) {
        return service.update(id, body);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/remove/many")
    public boolean deleteMany(@Validated @RequestBody DeleteManyApplyForMeDto body) {
        return service.deleteMany(body);
    }

    @PutMapping("/remove/all")
    public boolean deleteAll() {
        return service.deleteAll();
    }

    @GetMapping("/dummy")
    public void dummy() {
        var currentUser = CurrentUserUtil.getCurrentUser();
        System.out.println(currentUser);
    }
}
