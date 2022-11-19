package com.hydraulic.applyforme.superadmin.controller;

import com.hydraulic.applyforme.superadmin.service.SuperAdminStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistic/")
@RequiredArgsConstructor
public class SuperAdminStatsController {

    final SuperAdminStatsService superAdminStatsService;

    @GetMapping("/total-users")
    public ResponseEntity<Long> getTotalUserCount(){
        return ResponseEntity.ok(superAdminStatsService.getTotalUsers());
    }

    @GetMapping("/total-applications")
    public ResponseEntity<Long> getTotalApplicationCount(){
        return ResponseEntity.ok(superAdminStatsService.getTotalApplications());
    }

}
