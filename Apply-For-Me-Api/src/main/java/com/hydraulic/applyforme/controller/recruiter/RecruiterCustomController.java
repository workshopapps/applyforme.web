package com.hydraulic.applyforme.controller.recruiter;

import com.hydraulic.applyforme.model.response.RecruiterApplicantDetails;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.service.RecruiterCustomService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/entries")
    public ApplyForMeResponse getAllSubmission(
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
        return service.getList(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("/details/{id}/{role}/{salary}/{employementtype}")
    public RecruiterApplicantDetails getDetail(@PathVariable("id") Long id, @PathVariable("role") String role,
                                               @PathVariable("salary") String salary,
                                               @PathVariable("employementtype") String empoyment){
        return service.getOne(id, role, salary, empoyment);
    }
}