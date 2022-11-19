package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.service.RoleService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "statistic",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class SuperAdminStatController {

    private final RoleService.SuperAdminStatsService service;

    public SuperAdminStatController(RoleService.SuperAdminStatsService service) {
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
