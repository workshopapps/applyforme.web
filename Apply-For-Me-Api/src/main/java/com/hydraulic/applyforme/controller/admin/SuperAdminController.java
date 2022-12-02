package com.hydraulic.applyforme.controller.admin;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.admin.UpdatePasswordDto;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.service.SuperAdminCustomService;
import com.hydraulic.applyforme.service.SuperAdminService;
import com.hydraulic.applyforme.util.CurrentUserUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.hydraulic.applyforme.constants.PagingConstants.*;

@RestController
@RequestMapping(
        value = "super-admin",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class SuperAdminController {
    private final SuperAdminService service;
    private final SuperAdminCustomService secondService;
    public SuperAdminController(SuperAdminService service, SuperAdminCustomService secondService) {
        this.service = service;
        this.secondService = secondService;
    }

    @GetMapping("/profile")
    public Member getDetails() {
        var currentUser = CurrentUserUtil.getCurrentUser();
        return service.getDetails(currentUser.getId());
    }
    @PostMapping("/{id}/change-password")
    public String updatePassword(UpdatePasswordDto body) {
        var currentUser = CurrentUserUtil.getCurrentUser();
    	service.updatePassword(currentUser.getId(), body);
    	return "Password successfully changed";
    }
    @GetMapping("/application/entries")
    public ApplyForMeResponse getAll(
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir)
    {return secondService.findAll(pageNo, pageSize, sortBy, sortDir);}
}
