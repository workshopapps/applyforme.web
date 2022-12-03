package com.hydraulic.applyforme.controller.recruiter;

import com.hydraulic.applyforme.model.response.ApplicantDetailsResponse;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.service.RecruiterApplicantService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static com.hydraulic.applyforme.constants.PagingConstants.*;

@RestController
@RequestMapping(
        value = "recruiter/applicant",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class RecruiterApplicantController {

    private RecruiterApplicantService service;

    public RecruiterApplicantController(RecruiterApplicantService service) {
        this.service = service;
    }

    @PreAuthorize("hasAnyRole('Recruiter')")
    @GetMapping("/entries")
    public ApplyForMeResponse findEntries(
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(value = "from", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fromDate,
            @RequestParam(value = "to", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date toDate,
            @RequestParam(value = "q", required = false) String q) {
        return service.getEntries(pageNo, pageSize, sortBy, sortDir, q, fromDate, toDate);
    }

    @PreAuthorize("hasAnyRole('Recruiter')")
    @GetMapping("/detail/{id}")
    public ApplicantDetailsResponse getOne(@PathVariable Long id) {
        return service.getOne(id);
    }
}
