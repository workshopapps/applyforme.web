package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.response.AdminDashboardStatisticsOne;
import com.hydraulic.applyforme.model.response.ApplierJobSubmissionStatistics;
import com.hydraulic.applyforme.service.SuperAdminStatService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

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

    @GetMapping("/counts-part-one")
    public AdminDashboardStatisticsOne getPartOne(
            @RequestParam(value = "from", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fromDate,
            @RequestParam(value = "to", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date toDate
    ){
        return service.getStatistics(fromDate, toDate);
    }

    @GetMapping("/applier-submission")
    public List<ApplierJobSubmissionStatistics> getApplierSubmissionStatistics(@RequestParam(required = false, defaultValue = "1", name = "pageNo") Integer pageNumber) {
        return service.getAppliersTotalSubmissions(pageNumber);
    }

}
