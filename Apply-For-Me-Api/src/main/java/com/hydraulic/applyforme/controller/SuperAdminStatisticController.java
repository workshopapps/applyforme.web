package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.service.SuperAdminStatService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "statistic",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class SuperAdminStatisticController {

    private final SuperAdminStatService service;

    public SuperAdminStatisticController(SuperAdminStatService service) {
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

    @GetMapping("/appliers")
    public List<ApplierStatsDto> getAppliers(@RequestParam(required = false, defaultValue = "1", name = "pageNo") Integer pageNumber){
        return service.getAppliers(pageNumber);
    }

}
