package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.dto.ApplierDto;
import com.hydraulic.applyforme.service.ApplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ApplierController {

    @Autowired
    private ApplierService applierService;

    @GetMapping("/api/v1/appliers")
    public ResponseEntity<List<ApplierDto>> getAllAppliers(){
        return ResponseEntity.ok(this.applierService.getAllAppliers());
    }

}
