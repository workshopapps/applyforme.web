package com.hydraulic.applyforme.controller.admin;

import com.hydraulic.applyforme.service.superadmin.UpdateSuperAdminProfileService;
import com.hydraulic.applyforme.util.CurrentUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = "super-admin",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class UpdateSuperAdminProfileController {

    @Autowired
    UpdateSuperAdminProfileService service;

//
//    @PutMapping("/update/{id}")
//    public Member update(@Validated @RequestBody Member member, @PathVariable(name = "token") String token){
//        return service.update(token, member);
//}


    @GetMapping("/get")
    public Long get() {

        Long id = CurrentUserUtil.getCurrentUser().
        return service.getCurrentUser();
    }
}
