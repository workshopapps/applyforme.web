package com.hydraulic.applyforme.controller.admin;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.admin.UpdatePasswordDto;
import com.hydraulic.applyforme.service.SuperAdminService;
import com.hydraulic.applyforme.util.CurrentUserUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public Member getProfileDetails() {
        var currentUser = CurrentUserUtil.getCurrentUser();
        return service.getProfileDetails(currentUser.getId());

    }

    @PostMapping("/{id}/change-password")
    public String updatePassword(UpdatePasswordDto body) {
        var currentUser = CurrentUserUtil.getCurrentUser();
    	service.updatePassword(currentUser.getId(), body);
    	return "Password successfully changed";
    }
}
