package com.hydraulic.applyforme.controller.admin;

import com.hydraulic.applyforme.model.dto.admin.ApplierResponse;
import com.hydraulic.applyforme.service.superadmin.SuperAdminApplierService;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(
        value = "super-admin/applier",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class SuperAdminApplierController {

    private final SuperAdminApplierService service;

    public SuperAdminApplierController(SuperAdminApplierService service) {
        this.service = service;
    }

    @PreAuthorize("hasAnyRole('SuperAdministrator')")
    @GetMapping("/entries")
    public List<?> getHighestApplier() {
        return service.getApplier();
    }
}
