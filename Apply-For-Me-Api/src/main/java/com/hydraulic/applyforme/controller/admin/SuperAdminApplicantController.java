package com.hydraulic.applyforme.controller.admin;

import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.dto.professional.DeleteManyProfessionalDto;
import com.hydraulic.applyforme.service.superadmin.SuperAdminApplicantService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = "super-admin/applicant",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class SuperAdminApplicantController {

    private SuperAdminApplicantService service;

    public SuperAdminApplicantController(SuperAdminApplicantService service) {
        this.service = service;
    }

    @GetMapping("/detail/{id}")
    public Professional findOne(@PathVariable(name ="id") Long id) {
        return service.findOne(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/remove/many")
    public boolean deleteMany(@Validated @RequestBody DeleteManyProfessionalDto body) {
        return service.deleteMany(body);
    }

    @PutMapping("/remove/all")
    public boolean deleteAll() {
        return service.deleteAll();
    }
}
