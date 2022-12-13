package com.hydraulic.applyforme.controller.submission;

import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.service.JobSubmissionService;
import com.hydraulic.applyforme.util.CurrentUserUtil;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static com.hydraulic.applyforme.constants.PagingConstants.*;
import static com.hydraulic.applyforme.constants.PagingConstants.DEFAULT_SORT_DIRECTION;

@RestController
@RequestMapping(
        value = "job-submission",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class SubmissionController {

    private final JobSubmissionService service;

    public SubmissionController(JobSubmissionService service) {
        this.service = service;
    }

    @GetMapping("/entries/all")
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

    @GetMapping("/user/entries/all")
    public ApplyForMeResponse findUserEntries(
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(value = "from", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fromDate,
            @RequestParam(value = "to", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date toDate,
            @RequestParam(value = "q", required = false) String q) {
        var currentUser = CurrentUserUtil.getCurrentUser();
        return service.getUserEntries(pageNo, pageSize, sortBy, sortDir, q, fromDate, toDate, currentUser.getId());
    }

    @GetMapping("/detail/{id}")
    public Submission findOne(@PathVariable(name ="id") Long id) {
        return service.findOne(id);
    }
}
