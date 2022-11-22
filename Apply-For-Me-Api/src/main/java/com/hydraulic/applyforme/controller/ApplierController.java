package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.dto.ApplierDto;
import com.hydraulic.applyforme.service.ApplierService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "applier")
public class ApplierController {


    private final ApplierService applierService;

    public ApplierController(ApplierService applierService) {
        this.applierService = applierService;
    }


    @GetMapping("/appliers")
    public List<ApplierDto> getAllAppliers(){
        return applierService.getAllAppliers();
    }

}
