package com.hydraulic.applyforme.controller.recruiter;

import com.hydraulic.applyforme.model.dto.RecruiterCustomDto;
import com.hydraulic.applyforme.model.response.RecruiterApplicantDetails;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.service.RecruiterCustomService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static com.hydraulic.applyforme.constants.PagingConstants.*;
import static com.hydraulic.applyforme.constants.PagingConstants.DEFAULT_SORT_DIRECTION;

@RestController
@RequestMapping(
        value = "recruiter/application",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class RecruiterCustomController {

    private final RecruiterCustomService service;

    public RecruiterCustomController(RecruiterCustomService service) {
        this.service = service;
    }

    @PreAuthorize("hasAnyRole('Recruiter')")
    @GetMapping("/entries")
    public ApplyForMeResponse findEntries(
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
        return service.getEntries(pageNo, pageSize, sortBy, sortDir);
    }

    @PreAuthorize("hasAnyRole('Recruiter')")
    @GetMapping("/details")
    public RecruiterApplicantDetails getDetail(@RequestBody RecruiterCustomDto recruiterCustomDto){
        return service.getOne(recruiterCustomDto);
    }
}