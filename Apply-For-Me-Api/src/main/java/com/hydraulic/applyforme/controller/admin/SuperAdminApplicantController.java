package com.hydraulic.applyforme.controller.admin;

import com.hydraulic.applyforme.model.dto.professional.DeleteManyProfessionalDto;
import com.hydraulic.applyforme.model.response.ApplicantDetailsResponse;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.service.SuperAdminCustomService;
import com.hydraulic.applyforme.service.superadmin.SuperAdminApplicantService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static com.hydraulic.applyforme.constants.PagingConstants.*;
import static com.hydraulic.applyforme.constants.PagingConstants.DEFAULT_SORT_DIRECTION;

@RestController
@RequestMapping(
        value = "super-admin/applicant",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class SuperAdminApplicantController {

    private SuperAdminApplicantService service;
    private final SuperAdminCustomService superAdminCustomService;

    public SuperAdminApplicantController(SuperAdminApplicantService service, SuperAdminCustomService secondService, SuperAdminCustomService superAdminCustomService) {
        this.service = service;
        this.superAdminCustomService = superAdminCustomService;
    }

    @PreAuthorize("hasAnyRole('SuperAdministrator')")
    @GetMapping("/entries")
    public ApplyForMeResponse findEntries(
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(value = "from", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fromDate,
            @RequestParam(value = "to", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date toDate,
            @RequestParam(value = "q", required = false) String q) {
        return superAdminCustomService.getAll(pageNo, pageSize, sortBy, sortDir, q, fromDate, toDate);
    }

    @PreAuthorize("hasAnyRole('SuperAdministrator')")
    @GetMapping("/detail/{id}")
    public ApplicantDetailsResponse getOne(@PathVariable Long id) {
        return superAdminCustomService.getOne(id);
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
