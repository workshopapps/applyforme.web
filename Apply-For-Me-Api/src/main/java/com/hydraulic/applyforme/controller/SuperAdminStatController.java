package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.ApplierStatsDto;
import com.hydraulic.applyforme.service.RoleService;
import com.hydraulic.applyforme.service.SuperAdminStatService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "statistic",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class SuperAdminStatController {

    private final SuperAdminStatService service;

    public SuperAdminStatController(SuperAdminStatService service) {
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
