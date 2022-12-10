package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.dto.professionalprofile.DeleteManyProfessionalProfileDto;
import com.hydraulic.applyforme.model.dto.professionalprofile.ProfessionalProfileDto;
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

    @Override
    @Transactional
    public ProfessionalProfile update(Long id, ProfessionalProfileDto body) {
        ProfessionalProfile existingProfessionalProfile = repository.getOne(id);
        if (existingProfessionalProfile == null) {
            throw new ProfessionalProfileNotFoundException(id);
        }

        ProfessionalProfile professionalProfile = new ProfessionalProfile();
        professionalProfile = modelMapper.map(body, ProfessionalProfile.class);
        professionalProfile.setId(id);
        return repository.updateOne(professionalProfile);
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
    public boolean removeProfile(Long id) {
        boolean removed = repository.deleteJobProfile(id);
        if (removed) {
            return true;
        }
        else {
            throw new ProfessionalProfileNotFoundException(id);
        }
    }
}
