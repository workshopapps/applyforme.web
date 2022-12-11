package com.hydraulic.applyforme.service.impl;

import java.util.Random;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
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
	private final ProfessionalProfileRepository profileRepository;
	private final ProfessionalRepository professionalRepository;

	public OnboardingServiceImpl(MemberRepository memberRepository, 
			ProfessionalProfileRepository profileRepository,
			ProfessionalRepository professionalRepository) {
		super();
		this.memberRepository = memberRepository;
		this.profileRepository = profileRepository;
		this.professionalRepository = professionalRepository;
	}

	@Override
	@Transactional
	public OnboardingResponse onboard(TryItNowDTO body) {
		Member member = new Member();
		member.setFirstName(body.getFirstName());
		member.setLastName(body.getLastName());
		member.setEmailAddress(body.getEmailAddress());
		member.setPhoneNumber(body.getPhoneNumber());
		member.setPassword(encoder.encode(""+(int) Math.random()));
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
		profile.setSalaryRange(body.getSalaryRange());
		profile.setJobLocation(body.getJobLocation());	
		profile.setYearsOfExperience(body.getYearsOfExperience());
		profile.setEmploymentType(ProfessionalProfileUtil.getEmploymentType(body.getEmploymentType()));
		profileRepository.saveOne(profile);

		OnboardingResponse response = new OnboardingResponse();
		modelMapper.map(body, response);
		return response;
	}

	@Override
	public boolean changePassword(Long id, UpdatePasswordDto body) {
		Member member = memberRepository.getOne(id);
		System.out.println(member.getPassword());
		body.setExistingPassword(member.getPassword());
		System.out.println(body.getNewPassword());
		if(body.getNewPassword().equals(body.getConfirmationPassword())) {
			member.setPassword(body.getConfirmationPassword());
			return true;
		}
		return false;
	}

}
