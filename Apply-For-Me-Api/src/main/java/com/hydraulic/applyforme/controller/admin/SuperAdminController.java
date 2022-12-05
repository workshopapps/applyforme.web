package com.hydraulic.applyforme.controller.admin;

import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.service.SuperAdminCustomService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.admin.UpdatePasswordDto;
import com.hydraulic.applyforme.model.dto.admin.UpdateProfileDto;
import com.hydraulic.applyforme.service.SuperAdminService;
import com.hydraulic.applyforme.util.CurrentUserUtil;

import javax.validation.Valid;

import static com.hydraulic.applyforme.constants.PagingConstants.*;
import static com.hydraulic.applyforme.constants.PagingConstants.DEFAULT_SORT_DIRECTION;

@RestController
@RequestMapping(
        value = "super-admin",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class SuperAdminController {
    private final SuperAdminService service;
    public SuperAdminController(SuperAdminService service) {
        this.service = service;
    }

    @GetMapping("/profile")
    public Member getDetails() {
        var currentUser = CurrentUserUtil.getCurrentUser();
        return service.getProfileDetails(currentUser.getId());
    }

    @PostMapping("/change-password")
    public String updatePassword(@Validated @RequestBody UpdatePasswordDto body) {
        var currentUser = CurrentUserUtil.getCurrentUser();
        System.out.println(currentUser.getId());
    	service.updatePassword(currentUser.getId(), body);
    	return "Password successfully changed";
    }


    @PutMapping("/update")
    public Member updateProfile(@Valid @RequestBody UpdateProfileDto body) {
        return service.updateProfile(CurrentUserUtil.getCurrentUser().getId(), body);
    }


    @DeleteMapping("/recruiter/{id}")
    public boolean deleteMember(@PathVariable("id") Long id) {
    	return service.deleteMemberById(id);
    }
}
