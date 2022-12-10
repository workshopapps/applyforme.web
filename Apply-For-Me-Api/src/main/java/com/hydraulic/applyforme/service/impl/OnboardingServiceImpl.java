package com.hydraulic.applyforme.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.TryItNowDTO;
import com.hydraulic.applyforme.model.response.OnboardingResponse;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.ProfessionalProfileRepository;
import com.hydraulic.applyforme.service.OnboardingService;
import com.hydraulic.applyforme.util.ProfessionalProfileUtil;

public class OnboardingServiceImpl implements OnboardingService {

	@Autowired
	private ModelMapper modelMapper;

	private final MemberRepository memberRepository;
	private final ProfessionalProfileRepository profileRepository;

	public OnboardingServiceImpl(MemberRepository memberRepository, ProfessionalProfileRepository profileRepository) {
		super();
		this.memberRepository = memberRepository;
		this.profileRepository = profileRepository;
	}

	@Override
	public OnboardingResponse onboard(TryItNowDTO body) {
		Member member = new Member();
		member.setFirstName(body.getFirstName());
		member.setLastName(body.getLastName());
		member.setEmailAddress(body.getEmailAddress());
		member.setPhoneNumber(body.getPhoneNumber());
		memberRepository.saveOne(member);

		ProfessionalProfile profile = new ProfessionalProfile();
		profile.setDesiredJobTitle(body.getDesiredJobTitle());
		profile.setSalaryRange(body.getSalaryRange());
		profile.setYearsOfExperience(body.getYearsOfExperience());
		profile.setEmploymentType(ProfessionalProfileUtil.getEmploymentType(body.getEmploymentType()));
		profileRepository.saveOne(profile);

		OnboardingResponse response = new OnboardingResponse();
		modelMapper.map(body, response);
		return response;
	}

}
