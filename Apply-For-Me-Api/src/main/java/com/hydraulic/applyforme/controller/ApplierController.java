package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.dto.ApplierDto;
import com.hydraulic.applyforme.model.response.Response;
import com.hydraulic.applyforme.service.ApplierService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.hydraulic.applyforme.constants.PagingConstants.DEFAULT_PAGE_NUMBER;
import static com.hydraulic.applyforme.constants.PagingConstants.DEFAULT_PAGE_SIZE;

@RestController
@RequestMapping(
        value = "applier",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class ApplierController {

    private final ApplierService applierService;

    public ApplierController(ApplierService applierService) {
        this.applierService = applierService;
    }

    @GetMapping("/entries")
    public List<ApplierDto> getAllAppliers(){
        return applierService.getAllAppliers();
    }

    @GetMapping("/appliers/search")
    public Response getAllAppliers(@RequestParam String q,
                                   @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                   @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize){
        return applierService.getApplicants(pageNo, pageSize, q);
    }

}
