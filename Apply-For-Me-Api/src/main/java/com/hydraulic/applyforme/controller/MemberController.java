package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.admin.UpdatePasswordDto;
import com.hydraulic.applyforme.model.dto.member.UpdateMemberDto;
import com.hydraulic.applyforme.model.response.AdminDashboardStatisticsOne;
import com.hydraulic.applyforme.model.response.UserDashboardStatisticsOne;
import com.hydraulic.applyforme.model.security.UserDetailsImpl;
import com.hydraulic.applyforme.service.MemberService;
import com.hydraulic.applyforme.util.CurrentUserUtil;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping(
        value = {"member", "recruiter"},
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class MemberController {

    private MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @PreAuthorize("hasAnyRole('Professional', 'Recruiter', 'SuperAdministrator')")
    @GetMapping("/details")
    public Member details() {
    	UserDetailsImpl currentUser = CurrentUserUtil.getCurrentUser();
    	return service.findOne(currentUser.getId());
    }
    @PreAuthorize("hasAnyRole('Professional', 'Recruiter', 'SuperAdministrator')")
    @PutMapping("/update")
    public boolean update(@Validated @RequestBody UpdateMemberDto body) {
    	UserDetailsImpl currentUser = CurrentUserUtil.getCurrentUser();
        return service.update(currentUser.getId(), body);
    }

    @PreAuthorize("hasAnyRole('Professional', 'Recruiter')")
    @PutMapping("/update-password")
    public String updatePassword(@Validated @RequestBody UpdatePasswordDto body) {
        var currentUser = CurrentUserUtil.getCurrentUser();
        service.updatePassword(currentUser.getId(), body);
        return "Password successfully changed and updated";
    }

    @PreAuthorize("hasAnyRole('Professional')")
    @GetMapping("/stats")
    public UserDashboardStatisticsOne getPartOne(
            @RequestParam(value = "from", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fromDate,
            @RequestParam(value = "to", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date toDate
    ){
        var currentUser = CurrentUserUtil.getCurrentUser();
        return service.getStatistics(currentUser.getId(), fromDate, toDate);
    }

}
