package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.service.ProfessionalProfileService;
import com.hydraulic.applyforme.util.CurrentUserUtil;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static com.hydraulic.applyforme.constants.PagingConstants.*;

@RestController
@RequestMapping(
        value = "professional-profile",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class ProfessionalProfileController {

    private final ProfessionalProfileService service;

    public ProfessionalProfileController(ProfessionalProfileService service) {
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

    @PreAuthorize("hasAnyRole('Professional')")
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
    public ProfessionalProfile findOne(@PathVariable(name ="id") Long id) {
        return service.findOne(id);
    }

    @PreAuthorize("hasAnyRole('Professional')")
    @GetMapping("/user/detail/{id}")
    public ProfessionalProfile findOneUserProfessionalProfile(@PathVariable(name ="id") Long id) {
        var currentUser = CurrentUserUtil.getCurrentUser();
        return service.findOne(currentUser.getId(), id);
    }

}
