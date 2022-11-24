package com.hydraulic.applyforme.controller.admin;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.UpdatePasswordDTO;
import com.hydraulic.applyforme.service.SuperAdminService;

import java.util.Optional;

@RestController
@RequestMapping(
        value = "admin/member",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class SuperAdminMemberController {

    private SuperAdminService service;

    public SuperAdminMemberController(SuperAdminService service) {
        this.service = service;
    }

    @GetMapping("/detail/{id}")
    public Member getOneMember(@PathVariable(value="id") Long id) {
        return service.getDetailsById(id);
    }
    
    @PostMapping("/{id}/change-password")
    public ResponseEntity<?> changePassword(@PathVariable("id") Long id, UpdatePasswordDTO passwordDTO) {
    	service.updatePasswordById(id, passwordDTO);   	
    	return ResponseEntity.accepted().body("successful");
    }
    

    @GetMapping("/profile/{id}")
    public Member viewAdmin(@PathVariable(value = "id") Long id){
        return service.getAdmin(id);
    }

    @DeleteMapping("/remove/{id}")
    public boolean delete(@PathVariable(value = "id") Long id){
        return service.deleteMemberById(id);
    }
}
