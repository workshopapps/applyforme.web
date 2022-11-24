package com.hydraulic.applyforme.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.UpdatePasswordDTO;
import com.hydraulic.applyforme.service.SuperAdminService;

@RestController
@RequestMapping(
        value = "member",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class SuperAdminController {

    SuperAdminService service;

    public SuperAdminController(SuperAdminService service) {
        this.service = service;
    }

    @GetMapping("/detail/{id}")
    public Member getOneMember(@PathVariable(value="id") Long id) {
        return service.getDetailsById(id);
    }
    
    public ResponseEntity<?> changePassword(Long id, UpdatePasswordDTO passwordDTO) {
    	
    	service.updatePasswordById(id, passwordDTO);   	
    	
    	return ResponseEntity.ok("successful");
    }
    
}
