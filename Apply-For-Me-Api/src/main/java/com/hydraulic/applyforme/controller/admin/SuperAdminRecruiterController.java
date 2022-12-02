package com.hydraulic.applyforme.controller.admin;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.member.CreateRecruiterDto;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.service.EmailService;
import com.hydraulic.applyforme.service.superadmin.SuperAdminApplierService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.hydraulic.applyforme.constants.PagingConstants.*;
import static com.hydraulic.applyforme.constants.PagingConstants.DEFAULT_SORT_DIRECTION;

@RestController
@RequestMapping(
        value = "super-admin/recruiter",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class SuperAdminRecruiterController {

    private SuperAdminApplierService service;
    private EmailService emailService;

    public SuperAdminRecruiterController(SuperAdminApplierService service, EmailService emailService) {
        this.service = service;
        this.emailService = emailService;
    }

    @GetMapping("/entries")
    public ApplyForMeResponse findEntries(
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(value = "from", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fromDate,
            @RequestParam(value = "to", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date toDate,
            @RequestParam(value = "q", required = false) String q) {
        return service.getEntries(pageNo, pageSize, sortBy, sortDir, q, fromDate, toDate);
    }

    @PostMapping("/save")
    public Member save(@Validated @RequestBody CreateRecruiterDto dto) {
        Member member = service.saveRecruiter(dto);
//        emailService.confirmRecruiter(dto);
        return member;
    }

    @GetMapping("/sort-and-paginate")
    public List<Member> sortAndPaginateRecruiter(
            @RequestParam (value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false)int pageNo,
            @RequestParam (value = "pageSize", defaultValue = DEFAULT_PAGE_NUMBER, required = false)int pageSize,
            @RequestParam (value = "sortBy", defaultValue = DEFAULT_PAGE_NUMBER, required = false)String sortBy,
            @RequestParam (value = "sortDir", defaultValue = DEFAULT_PAGE_NUMBER, required = false)String sortDir)
    {
        return service.sortAndPaginateRecruiter(pageNo,pageSize,sortBy,sortDir);

    }

}
