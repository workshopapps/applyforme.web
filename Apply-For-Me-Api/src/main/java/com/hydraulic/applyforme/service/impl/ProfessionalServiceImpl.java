package com.hydraulic.applyforme.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.response.JobDescriptionResponse;

import java.util.Set;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.response.JobSummaryResponse;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.professional.ProfessionalDto;
import com.hydraulic.applyforme.model.exception.ProfessionalNotFoundException;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.ProfessionalRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalJpaRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalProfileJpaRepository;
import com.hydraulic.applyforme.service.ProfessionalService;
import com.hydraulic.applyforme.util.ProfessionalProfileUtil;

@Service
public class ProfessionalServiceImpl implements ProfessionalService {
	private final ProfessionalRepository repository;
	private final ProfessionalJpaRepository professionalJpaRepository;
	private final ProfessionalProfileJpaRepository professionalProfileJpaRepository;
	private final JobSubmissionRepository jobSubmissionRepository;
	@Autowired
	private MemberRepository memberRepository;

	public ProfessionalServiceImpl(ProfessionalRepository repository,
			ProfessionalJpaRepository professionalJpaRepository,
			ProfessionalProfileJpaRepository professionalProfileJpaRepository,
			JobSubmissionRepository jobSubmissionRepository) {
		this.repository = repository;
		this.professionalJpaRepository = professionalJpaRepository;
		this.professionalProfileJpaRepository = professionalProfileJpaRepository;
		this.jobSubmissionRepository = jobSubmissionRepository;
	}

	@Override
	public List<Professional> findAll(Integer pageOffset) {
		return repository.getAll(pageOffset);
	}

	@Override
	@Transactional(readOnly = true)
	public Professional findOne(Long id) {
		Member member = memberRepository.getOne(id);
		if (member == null) {
			throw new ProfessionalNotFoundException(id);
		}
		Professional professional = repository.getOne(member.getId());
		professional.setSubmissions(null);
		professional.setProfessionalProfiles(null);
		return professional;
	}

	@Override
	@Transactional
	public boolean updateProfile(ProfessionalDto professionalDto, Long id) {
		Professional professional = findOne(id);
		if (professional == null) {
			throw new ProfessionalNotFoundException(id);
		}

		System.out
				.println("Before => professional.isAvailableForInterview(): " + professional.isAvailableForInterview());

		professional.setAvailableForInterview(professionalDto.isAvailableForInterview());

		System.out.println(
				"After => professional.isAvailableForInterview(): " + professionalDto.isAvailableForInterview());

		professional.setLinkedinLink(professionalDto.getLinkedinLink());
		professional.setFacebookLink(professionalDto.getFacebookLink());
		professional.setTwitterLink(professionalDto.getTwitterLink());
		professional.setInstagramLink(professionalDto.getInstagramLink());
		professional.setHobbies(professionalDto.getHobbies());
		professional.setOtherLink1(professionalDto.getOtherLink1());
		professional.setOtherLink2(professionalDto.getOtherLink2());
		professional.setOtherLink3(professionalDto.getOtherLink3());
		repository.updateOne(professional);

		return true;
	}

	@Override
	public Page<Professional> retrieveAllProfessionals(int pageNo, int pageSize) {
		Pageable page = PageRequest.of(pageNo, pageSize, Sort.Direction.DESC);
		Page<Professional> applicantsPage = professionalJpaRepository.findAll(page);
		if (applicantsPage.isEmpty()) {
			throw new ProfessionalNotFoundException(applicantsPage.getTotalElements());
		}
		return applicantsPage;
	}

	@Override
	public List<ProfessionalProfile> findAllJobProfile(Long id) {
		List<ProfessionalProfile> jobProfiles = professionalProfileJpaRepository.getJobProfiles(id);

		jobProfiles.forEach(profile -> {
			profile.getProfessional().setSubmissions(null);
			profile.getProfessional().setProfessionalProfiles(null);
		});

		return jobProfiles;
	}

	@Override
	public JobDescriptionResponse viewJobDescription(Long professionalId, Long submissionId) {
		Optional<Professional> professional = professionalJpaRepository.findById(professionalId);
		if (professional.isEmpty()) {
			throw new ProfessionalNotFoundException(professionalId);
		}
		List<Submission> submissions = jobSubmissionRepository.findAllByProfessionalId(professionalId);

		for (Submission submission : submissions) {
			if (submission.getId().equals(submissionId)) {
				submission.getApplier().setSubmissions(null);
				JobDescriptionResponse jobDescriptionResponse = JobDescriptionResponse.builder()
						.id(submission.getId())
						.applier(submission.getApplier())
						.jobLocation(submission.getJobLocation())
						.jobLink(submission.getJobLink())
						.jobLocationType(submission.getJobLocationType().getValue())
						.otherComment(submission.getOtherComment())						.jobTitle(submission.getJobTitle())
						.jobSummary(submission.getSummary()).
						jobCompany(submission.getJobCompany())
						.createdOn(submission.getCreatedOn())
						.updatedOn(submission.getUpdatedOn())
						.build();
				return jobDescriptionResponse;
			}

		}
		return null;
	}

	@Override
	public List<JobSummaryResponse> retrieveProfessionalSubmissions(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
