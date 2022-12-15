package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.professionalprofile.DeleteManyProfessionalProfileDto;
import com.hydraulic.applyforme.model.dto.professionalprofile.ProfessionalProfileDto;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.model.exception.ProfessionalNotFoundException;
import com.hydraulic.applyforme.model.exception.ProfessionalProfileNotFoundException;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.ProfessionalProfileRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalJpaRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalProfileJpaRepository;
import com.hydraulic.applyforme.service.job.ProfessionalJobProfileService;
import com.hydraulic.applyforme.util.ProfessionalProfileUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ProfessionalJobProfileServiceImpl implements ProfessionalJobProfileService {

    private final ProfessionalProfileRepository repository;

    private final MemberRepository memberRepository;
    private final ProfessionalJpaRepository professionalJpaRepository;

    ProfessionalProfileJpaRepository jpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ProfessionalJobProfileServiceImpl(ProfessionalProfileRepository repository,
                                             MemberRepository memberRepository,
                                             ProfessionalJpaRepository professionalJpaRepository) {
        this.repository = repository;
        this.memberRepository = memberRepository;
        this.professionalJpaRepository = professionalJpaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProfessionalProfile> findAll(Integer pageOffset) {
        return repository.getAll(pageOffset);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProfessionalProfile> findAll() {
        return repository.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ProfessionalProfile findOne(Long id) {
        ProfessionalProfile professionalProfile = repository.getOne(id);
        if (professionalProfile == null) {
            throw new ProfessionalProfileNotFoundException(id);
        }
        return professionalProfile;
    }

    @Override
    @Transactional
    public ProfessionalProfile save(Long memberId, ProfessionalProfileDto body) {
        ProfessionalProfile professionalProfile = ProfessionalProfile.builder()
                .mainProfile(false)
                .profileTitle(body.getProfileTitle())
                .desiredJobTitle(body.getDesiredJobTitle())
                .resumeLink(body.getResumeLink())
                .coverLetterSubject(body.getCoverLetterSubject())
                .coverLetterContent(body.getCoverLetterContent())
                .employmentType(ProfessionalProfileUtil.getEmploymentType(body.getEmploymentType()))
                .jobLocation(body.getJobLocation())
                .jobSeniority(ProfessionalProfileUtil.getJobSeniority(body.getJobSeniority()))
                .preferredJobLocationType(ProfessionalProfileUtil.getJobLocationType(body.getPreferredJobLocationType()))
                .includedKeywords(body.getIncludedKeywords())
                .otherComment(body.getOtherComment())
                .otherSkills(body.getOtherSkills())
                .yearsOfExperience(body.getYearsOfExperience())
                .salaryRange(body.getSalaryRange())
                .build();
        Professional professional = professionalJpaRepository.getProfessional(memberId);
        if (professional == null) {
            throw new ProfessionalProfileNotFoundException("Unknown");
        }

        professionalProfile.setProfessional(professional);
        ProfessionalProfile savedProfessionalProfile = repository.saveOne(professionalProfile);
        savedProfessionalProfile.getProfessional().setSubmissions(null);
        savedProfessionalProfile.getProfessional().setProfessionalProfiles(null);
        return savedProfessionalProfile;
    }

//    @Override
//    @Transactional
//    public ProfessionalProfile update(Long id, ProfessionalProfileDto body) {
//        ProfessionalProfile existingProfessionalProfile = repository.getOne(id);
//        if (existingProfessionalProfile == null) {
//            throw new ProfessionalProfileNotFoundException(id);
//        }
//
//        ProfessionalProfile professionalProfile = new ProfessionalProfile();
//        professionalProfile = modelMapper.map(body, ProfessionalProfile.class);
//        professionalProfile.setId(id);
//        return repository.updateOne(professionalProfile);
//    }

    @Override
    @Transactional
    public ProfessionalProfile update(Long id, ProfessionalProfileDto body) {
        ProfessionalProfile professionalProfile = repository.getOne(id);
        if (professionalProfile == null) {
            throw new ProfessionalNotFoundException(id);
        }

        if (body.getOtherComment() != null) {
            professionalProfile.setOtherComment(body.getOtherComment());
        }
        if (body.getOtherSkills() != null) {
            professionalProfile.setOtherSkills(body.getOtherSkills());
        }
        if (body.getCoverLetterLink() != null) {
            professionalProfile.setCoverLetterLink(body.getCoverLetterLink());
        }
        if (body.getCoverLetterSubject() != null) {
            professionalProfile.setCoverLetterSubject(body.getCoverLetterSubject());
        }
        if (body.getCoverLetterContent() != null) {
            professionalProfile.setCoverLetterContent(body.getCoverLetterContent());
        }
        if (body.getProfileTitle() != null) {
            professionalProfile.setProfileTitle(body.getProfileTitle());
        }
        if (body.getYearsOfExperience() != null) {
            professionalProfile.setYearsOfExperience(body.getYearsOfExperience());
        }
        if (body.getPreferredJobLocationType() != null) {
            professionalProfile.setPreferredJobLocationType(ProfessionalProfileUtil.getJobLocationType(body.getPreferredJobLocationType()));
        }
        if (body.getSalaryRange() != null) {
            professionalProfile.setSalaryRange(body.getSalaryRange());
        }
        if (body.getResumeLink() != null) {
            professionalProfile.setResumeLink(body.getResumeLink());
        }
        if (body.getPassportLink() != null) {
            professionalProfile.setPassportLink(body.getPassportLink());
        }
        if (body.getJobSeniority() != null) {
            professionalProfile.setJobSeniority(ProfessionalProfileUtil.getJobSeniority(body.getJobSeniority()));
        }
        if (body.getJobLocation() != null) {
            professionalProfile.setJobLocation(body.getJobLocation());
        }
        if (body.getIncludedKeywords() != null) {
            professionalProfile.setIncludedKeywords(body.getIncludedKeywords());
        }
        if (body.getEmploymentType() != null) {
            professionalProfile.setEmploymentType(ProfessionalProfileUtil.getEmploymentType(body.getEmploymentType()));
        }
        if (body.getIndustry() != null) {
            professionalProfile.setIndustry(body.getIndustry());
        }
        if (body.getDesiredJobTitle() != null) {
            professionalProfile.setDesiredJobTitle(body.getDesiredJobTitle());
        }
        professionalProfile = repository.updateOne(professionalProfile);
        professionalProfile.getProfessional().setProfessionalProfiles(null);
        professionalProfile.getProfessional().setSubmissions(null);
        professionalProfile.getProfessional().setMember(null);


        return professionalProfile;
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        boolean removed = repository.remove(id);
        if (removed) {
            return true;
        }
        else {
            throw new ProfessionalProfileNotFoundException(id);
        }
    }

    @Override
    @Transactional
    public boolean deleteMany(DeleteManyProfessionalProfileDto manyDto) {
        return repository.removeMany(manyDto.getIds());
    }

    @Override
    @Transactional
    public boolean deleteAll() {
        return repository.removeAll();
    }

	@Override
    @Transactional
	public boolean deleteByProfileId(Long id, Long profile_id) {
		//find the professional
		Member member = memberRepository.getOne(id);

        if (member == null) {
            throw new MemberNotFoundException(id);
        }
		
		//fetch the professional profile
		Professional professional = professionalJpaRepository.getProfessional(member.getId());

        if (professional == null) {
            throw new ProfessionalNotFoundException(member.getId());
        }

		List<ProfessionalProfile> profiles = repository.findByProfessionalId(professional.getId());
		//delete one from profile
		
		for (ProfessionalProfile profile : profiles) {

			if ((profile.getId().longValue()) == profile_id) {
				repository.deleteById(profile.getId());
				return true;
			}
		}
		
		return false;
	}

    @Override
    @Transactional(readOnly = true)
    public List<ProfessionalProfile> findAllJobProfiles() {
        return jpaRepository.getAllJobProfileSubmission();
    }

}

