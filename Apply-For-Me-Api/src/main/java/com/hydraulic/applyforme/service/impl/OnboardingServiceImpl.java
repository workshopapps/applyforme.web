package com.hydraulic.applyforme.service.impl;

import java.util.Calendar;
import java.util.Optional;
import java.util.Random;

import javax.transaction.Transactional;

import com.hydraulic.applyforme.model.domain.*;
import com.hydraulic.applyforme.model.dto.admin.NewPasswordDto;
import com.hydraulic.applyforme.model.enums.RoleType;
import com.hydraulic.applyforme.model.exception.*;
import com.hydraulic.applyforme.repository.jpa.CountryJpaRepository;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.repository.jpa.RoleJpaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hydraulic.applyforme.model.dto.TryItNowDTO;
import com.hydraulic.applyforme.model.dto.admin.UpdatePasswordDto;
import com.hydraulic.applyforme.model.response.OnboardingResponse;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.ProfessionalProfileRepository;
import com.hydraulic.applyforme.repository.ProfessionalRepository;
import com.hydraulic.applyforme.service.OnboardingService;
import com.hydraulic.applyforme.util.ProfessionalProfileUtil;

@Service
public class OnboardingServiceImpl implements OnboardingService {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private PasswordEncoder encoder;

	private final MemberRepository memberRepository;

	private final MemberJpaRepository memberJpaRepository;
	private final RoleJpaRepository roleJpaRepository;
	private final ProfessionalProfileRepository profileRepository;
	private final ProfessionalRepository professionalRepository;

	private CountryJpaRepository countryJpaRepository;

	public OnboardingServiceImpl(MemberRepository memberRepository,
			ProfessionalProfileRepository profileRepository,
			ProfessionalRepository professionalRepository,
								 MemberJpaRepository memberJpaRepository,
								 RoleJpaRepository roleJpaRepository,
								 CountryJpaRepository countryJpaRepository) {
		super();
		this.memberRepository = memberRepository;
		this.profileRepository = profileRepository;
		this.professionalRepository = professionalRepository;
		this.memberJpaRepository = memberJpaRepository;
		this.roleJpaRepository = roleJpaRepository;
		this.countryJpaRepository = countryJpaRepository;
	}

	@Override
	@Transactional
	public OnboardingResponse onboard(TryItNowDTO body) {
		boolean existingMember = memberJpaRepository.existsByEmailAddress(body.getEmailAddress());

		if (existingMember) {
			throw new EmailAlreadyExistsException();
		}

		Optional<Role> existingRole = roleJpaRepository.findByCode(RoleType.PROFESSIONAL.getValue());

		if (existingRole.isEmpty()) {
			throw new RoleNotFoundException(RoleType.PROFESSIONAL.getValue());
		}

		final String countryTitle = "Other";

		Optional<Country> nationality = countryJpaRepository.findByTitleAndAbbreviation(countryTitle, "OOO");

		if (nationality.isEmpty()) {
			throw new CountryNotFoundException(countryTitle);
		}

		Optional<Country> countryOfResidence = countryJpaRepository.findByTitleAndAbbreviation(countryTitle, "OOO");

		if (countryOfResidence.isEmpty()) {
			throw new CountryNotFoundException(countryTitle);
		}

		long password = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		long onboardToken = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		long onboardToken1 = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		long onboardToken2 = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		long username = new Random().nextInt(900000) + 100000;

		Member member = new Member();
		member.setFirstName(body.getFirstName());
		member.setLastName(body.getLastName());
		member.setEmailAddress(body.getEmailAddress());
		member.setPhoneNumber(body.getPhoneNumber());
		member.setPassword(encoder.encode(""+ password));
		member.addRole(existingRole.get());
		member.setNationality(nationality.get());
		member.setCountryOfResidence(countryOfResidence.get());
		member.setUsername((body.getEmailAddress().split("@")[0]) + username);
		member.setOnboardToken(String.valueOf(onboardToken) + String.valueOf(onboardToken1) + String.valueOf(onboardToken2));

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 1990);
		member.setDateOfBirth(calendar.getTime());
		memberRepository.saveOne(member);
		
		Professional professional = Professional.builder()
                .member(member)
                .submissions(null) 
                .professionalProfiles(null)
                .build();
		professionalRepository.saveOne(professional);

		ProfessionalProfile profile = new ProfessionalProfile();
		profile.setProfessional(professional);
		profile.setProfileTitle(body.getProfileTitle());
		profile.setDesiredJobTitle(body.getDesiredJobTitle());
		profile.setSalaryRange(body.getSalaryRange());
		profile.setJobLocation(body.getJobLocation());	
		profile.setYearsOfExperience(body.getYearsOfExperience());
		profile.setEmploymentType(ProfessionalProfileUtil.getEmploymentType(body.getEmploymentType()));
		profile.setJobSeniority(ProfessionalProfileUtil.getJobSeniority(body.getJobSeniority()));
		profile.setPreferredJobLocationType(ProfessionalProfileUtil.getJobLocationType(body.getPreferredJobLocationType()));
		profileRepository.saveOne(profile);

		OnboardingResponse response = new OnboardingResponse();
		response.setId(member.getId());
		modelMapper.map(body, response);
		response.setOnBoardToken(member.getOnboardToken());
		return response;
	}

	@Override
	@Transactional
	public Member changePassword(String onboardToken, NewPasswordDto body) {
		Member member = memberJpaRepository.findByOnboardToken(onboardToken);

		if (member == null) {
			throw new InvalidOnboardTokenException(onboardToken);
		}

		if (!body.getNewPassword().equals(body.getConfirmationPassword())) {
			throw new PasswordMismatchException();
		}
		member.setPassword(body.getConfirmationPassword());
		memberRepository.updateOne(member);
		return member;
	}

}
