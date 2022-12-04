package com.hydraulic.applyforme.controller.admin;

import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.service.SuperAdminCustomService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.admin.UpdatePasswordDto;
import com.hydraulic.applyforme.service.SuperAdminService;
import com.hydraulic.applyforme.util.CurrentUserUtil;

import static com.hydraulic.applyforme.constants.PagingConstants.*;
import static com.hydraulic.applyforme.constants.PagingConstants.DEFAULT_SORT_DIRECTION;

@RestController
@RequestMapping(
        value = "super-admin",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class SuperAdminController {
    private final SuperAdminService service;
    private final SuperAdminCustomService secondService;
    public SuperAdminController(SuperAdminService service, SuperAdminCustomService secondService) {
        this.service = service;
        this.secondService = secondService;
    }

    @GetMapping("/profile")
    public Member getDetails() {
        var currentUser = CurrentUserUtil.getCurrentUser();
        return service.getDetails(currentUser.getId());
    }
    @PostMapping("/change-password")
    public String updatePassword(@Validated @RequestBody UpdatePasswordDto body) {
        var currentUser = CurrentUserUtil.getCurrentUser();
        System.out.println(currentUser.getId());
    	service.updatePassword(currentUser.getId(), body);
    	return "Password successfully changed";
    }
    
    @DeleteMapping("/recruiter/{id}")
    public boolean deleteMember(@PathVariable("id") Long id) {
    	return service.deleteMemberById(id);
    }

    @GetMapping("/application/all")
    public ApplyForMeResponse getAllApplication(
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return secondService.findAll(pageNo, pageSize, sortBy, sortDir);
    }
}
