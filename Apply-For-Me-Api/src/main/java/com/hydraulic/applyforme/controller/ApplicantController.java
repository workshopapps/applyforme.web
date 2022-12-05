package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.hydraulic.applyforme.constants.PagingConstants.*;
import static com.hydraulic.applyforme.constants.PagingConstants.DEFAULT_SORT_DIRECTION;

@RestController
@RequestMapping(
        value = "applicant",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class ApplicantController {

    private final ApplicantService service;

    @Autowired
    public ApplicantController(ApplicantService service) {
        this.service = service;
    }


    @GetMapping("/entries")
    public ApplyForMeResponse getAllSubmission(
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
        return service.getApplicationList(pageNo, pageSize, sortBy, sortDir);
    }

    public void dummy() {

    }
}
