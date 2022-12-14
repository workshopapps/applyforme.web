package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.repository.ProfessionalProfileRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalProfileJpaRepository;
import com.hydraulic.applyforme.service.ProfessionalProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import static com.hydraulic.applyforme.util.ApplyForMeUtil.createPageable;

@Service
public class ProfessionalProfileServiceImpl implements ProfessionalProfileService {

    private final ProfessionalProfileJpaRepository jpaRepository;

    private final ProfessionalProfileRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public ProfessionalProfileServiceImpl(ProfessionalProfileRepository repository,
                                          ProfessionalProfileJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public ApplyForMeResponse getEntries(int pageNo, int pageSize, String sortBy, String sortDir, String q, Date from, Date to) {
        Page<ProfessionalProfile> professionalProfiles = null;

        if (from != null && to != null && q != null && q.trim() != "") {
            professionalProfiles = jpaRepository.getEntries(from, to, q, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        else if (from != null && to != null) {
            professionalProfiles = jpaRepository.getEntries(from, to, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        if (q != null && q.trim() != "") {
            professionalProfiles = jpaRepository.getEntries(q, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        else {
            professionalProfiles = jpaRepository.getEntries(createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        return getJobProfessionalProfileResponse(professionalProfiles);
    }

    @Override
    @Transactional(readOnly = true)
    public ApplyForMeResponse getUserEntries(int pageNo, int pageSize, String sortBy, String sortDir, String q, Date from, Date to, Long userId) {
        Page<ProfessionalProfile> professionalProfiles = null;

        if (from != null && to != null && q != null && q.trim() != "") {
            professionalProfiles = jpaRepository.getUserEntries(from, to, q, userId, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        else if (from != null && to != null) {
            professionalProfiles = jpaRepository.getUserEntries(from, to, userId, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        if (q != null && q.trim() != "") {
            professionalProfiles = jpaRepository.getUserEntries(q, userId, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        else {
            professionalProfiles = jpaRepository.getUserEntries(userId, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        return getJobProfessionalProfileResponse(professionalProfiles);
    }

    @Override
    public ProfessionalProfile findOne(Long id) {
        ProfessionalProfile professionalProfile = repository.getOne(id);
        professionalProfile.setProfessional(null);
        return professionalProfile;
    }

    @Override
    public ProfessionalProfile findOne(Long memberId, Long id) {
        ProfessionalProfile professionalProfile = jpaRepository.getOneUserProfessionalProfile(memberId, id);
        professionalProfile.getProfessional().setProfessionalProfiles(null);
        professionalProfile.getProfessional().getMember().setRoles(null);
        professionalProfile.getProfessional().setProfessionalProfiles(null);
        return professionalProfile;
    }
    private ApplyForMeResponse getJobProfessionalProfileResponse(Page<ProfessionalProfile> professionalProfiles) {
        Collection<ProfessionalProfile> results = professionalProfiles
                .getContent()
                .stream()
                .map(x -> {
                    x.getProfessional().setSubmissions(null);
                    x.getProfessional().setProfessionalProfiles(null);
                    x.getProfessional().getMember().setRoles(null);
                    x.getProfessional().setMember(null);
                    x.setProfessional(null);
                    return modelMapper.map(x, ProfessionalProfile.class);
                })
                .collect(Collectors.toList());

        ApplyForMeResponse response = new ApplyForMeResponse();
        response.setContent(results);
        response.setPageNo(professionalProfiles.getNumber());
        response.setPageSize(professionalProfiles.getSize());
        response.setTotalElements(professionalProfiles.getTotalElements());
        response.setTotalPages(professionalProfiles.getTotalPages());
        response.setLast(professionalProfiles.isLast());
        return response;
    }
}
