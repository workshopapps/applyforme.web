package com.hydraulic.applyforme.service.impl;

import java.util.List;

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

@Service
public class ProfessionalServiceImpl implements ProfessionalService {
	private final ProfessionalRepository repository;
	private final ProfessionalJpaRepository professionalJpaRepository;
	private final ProfessionalProfileJpaRepository professionalProfileJpaRepository;
	
	@Autowired
	private MemberRepository memberRepository;

	public ProfessionalServiceImpl(ProfessionalRepository repository,
			ProfessionalJpaRepository professionalJpaRepository,
			ProfessionalProfileJpaRepository professionalProfileJpaRepository) {
		this.repository = repository;
		this.professionalJpaRepository = professionalJpaRepository;
		this.professionalProfileJpaRepository = professionalProfileJpaRepository;
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

}
