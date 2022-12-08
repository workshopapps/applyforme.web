package com.hydraulic.applyforme.controller.admin;

import javax.validation.Valid;

import com.hydraulic.applyforme.model.dto.admin.UpdatePasswordDto;
import com.hydraulic.applyforme.model.dto.admin.UpdateProfileDto;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.service.SuperAdminService;
import com.hydraulic.applyforme.util.CurrentUserUtil;


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
    	service.updatePassword(currentUser.getId(), body);
    	return "password successfully changed";
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
