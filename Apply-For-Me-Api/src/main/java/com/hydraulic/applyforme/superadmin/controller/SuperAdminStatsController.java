package com.hydraulic.applyforme.superadmin.controller;

import com.hydraulic.applyforme.superadmin.service.SuperAdminStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "statistic",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)public class SuperAdminStatsController {

    private final SuperAdminStatsService service;

    public SuperAdminStatsController(SuperAdminStatsService service) {
        this.service = service;
    }

    @GetMapping("/total-users")
    public Long getTotalUserCount(){
        return service.getTotalUsers();
    }

    @GetMapping("/total-applications")
    public Long getTotalApplicationCount(){
        return service.getTotalApplications();
    }

}
