package com.hydraulic.applyforme.controller;

import static com.hydraulic.applyforme.constants.PagingConstants.DEFAULT_PAGE_NUMBER;
import static com.hydraulic.applyforme.constants.PagingConstants.DEFAULT_PAGE_SIZE;
import static com.hydraulic.applyforme.constants.PagingConstants.DEFAULT_SORT_BY;
import static com.hydraulic.applyforme.constants.PagingConstants.DEFAULT_SORT_DIRECTION;

import java.util.List;

import com.hydraulic.applyforme.model.response.JobDescriptionResponse;
import com.hydraulic.applyforme.model.response.JobSummaryResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.professional.ProfessionalDto;
import com.hydraulic.applyforme.model.security.UserDetailsImpl;
import com.hydraulic.applyforme.service.ProfessionalService;
import com.hydraulic.applyforme.util.CurrentUserUtil;

@RestController
@RequestMapping(value = "professional", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ProfessionalController {

	private ProfessionalService service;

	public ProfessionalController(ProfessionalService service) {
		this.service = service;
	}

	@GetMapping("/entries")
	public List<Professional> findAll(
			@RequestParam(required = false, defaultValue = "1", name = "page") Integer pageOffset) {
		return service.findAll(pageOffset);
	}
	
	@GetMapping("/detail")
	public Professional findOne(Long id) {
		UserDetailsImpl currentUser = CurrentUserUtil.getCurrentUser();
		return service.findOne(currentUser.getId());
	}

	@PutMapping("/update")
	public boolean update(@Validated @RequestBody ProfessionalDto body) {
		Long id = CurrentUserUtil.getCurrentUser().getId();
		return service.updateProfile(body, id);
	}

	@GetMapping("/applicants/{pageNo}/{pageSize}")
	public Page<Professional> retrieveApplicants(@PathVariable int pageNo, @PathVariable int pageSize) {
		return service.retrieveAllProfessionals(pageNo, pageSize);
	}

	@GetMapping("/profiles")
	public List<ProfessionalProfile> getAllJobProfiles(
			 @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
	            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
	            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
	            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		UserDetailsImpl currentUser = CurrentUserUtil.getCurrentUser();
		return service.findAllJobProfile(currentUser.getId());
	}

    @GetMapping("/job-description/{jobId}")
    public JobDescriptionResponse getJobDescription(@PathVariable Long jobId){
        var currentUser = CurrentUserUtil.getCurrentUser();
        return service.viewJobDescription(currentUser.getId(), jobId);

    }
	@GetMapping("/view-application-summary")
	public List<JobSummaryResponse> retrieveApplicantJobSummary(){
		Long id = CurrentUserUtil.getCurrentUser().getId();
		return  service.retrieveProfessionalSubmissions(id);
	}
}

