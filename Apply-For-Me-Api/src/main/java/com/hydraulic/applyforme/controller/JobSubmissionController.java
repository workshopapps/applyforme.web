package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.pojo.SubmissionResponse;
import com.hydraulic.applyforme.service.JobSubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.hydraulic.applyforme.constants.AppConstants.*;

@RestController
@RequestMapping(
        value = "submission",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class JobSubmissionController {

    private final JobSubmissionService service;

    public JobSubmissionController(JobSubmissionService service) {
        this.service = service;
    }
    @GetMapping("/applier/count/{applierId}")
    public Long totalApplierEntry(@PathVariable(name = "applierId") Long id){
        return service.countAllSubmissions(id);
    }

    @GetMapping("/entries")
    public SubmissionResponse getAllSubmission(
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir){
        return service.getAllJobSubmission(pageNo, pageSize, sortBy, sortDir);
    }
    @GetMapping("/entries/search")
    public SubmissionResponse getAllSubmissionBySearch(
            @RequestParam String q,
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir){
        return service.filterJobSubmission(pageNo, pageSize, sortBy, sortDir, q);
    }


}
