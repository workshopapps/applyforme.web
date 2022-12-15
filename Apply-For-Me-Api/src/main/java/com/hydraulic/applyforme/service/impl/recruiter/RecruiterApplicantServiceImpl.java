package com.hydraulic.applyforme.service.impl.recruiter;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.dto.member.MemberDto;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.model.response.ApplicantDetailsResponse;
import com.hydraulic.applyforme.model.response.RecruiterStats;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.ProfessionalRepository;
import com.hydraulic.applyforme.repository.jpa.JobSubmissionRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalJpaRepository;
import com.hydraulic.applyforme.repository.jpa.SuperAdminMemberJpaRepository;
import com.hydraulic.applyforme.service.RecruiterApplicantService;
import com.hydraulic.applyforme.util.CurrentUserUtil;
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
public class RecruiterApplicantServiceImpl implements RecruiterApplicantService {

    private final ProfessionalRepository repository;
    private final SuperAdminMemberJpaRepository jpaRepository;
    private final MemberRepository memberRepository;
    private final ProfessionalJpaRepository professionalJpaRepository;
    private final com.hydraulic.applyforme.repository.JobSubmissionRepository jobSubmissionRepository;

    @Autowired
    private ModelMapper mapper;

    public RecruiterApplicantServiceImpl(ProfessionalRepository repository,
                                         SuperAdminMemberJpaRepository jpaRepository,
                                         MemberRepository memberRepository,
                                         ProfessionalJpaRepository professionalJpaRepository, JobSubmissionRepository jobSubmissionRepository, JobSubmissionRepository jobSubmissionJpaRepository, com.hydraulic.applyforme.repository.JobSubmissionRepository jobSubmissionRepository1, ModelMapper mapper) {
        this.repository = repository;
        this.jpaRepository = jpaRepository;
        this.memberRepository = memberRepository;
        this.professionalJpaRepository = professionalJpaRepository;
        this.jobSubmissionRepository = jobSubmissionRepository1;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public ApplyForMeResponse getEntries(int pageNo, int pageSize, String sortBy, String sortDir, String q, Date from, Date to) {
        Page<Member> members = null;

        if (from != null && to != null && q != null && q.trim() != "") {
            members = jpaRepository.getEntries(from, to, q, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        else if (from != null && to != null) {
            members = jpaRepository.getEntries(from, to, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        if (q != null && q.trim() != "") {
            members = jpaRepository.getEntries(q, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        else {
            members = jpaRepository.getEntries(createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        return getMemberResponse(members);
    }

    private ApplyForMeResponse getMemberResponse(Page<Member> members) {
        Collection<MemberDto> results = members
                .getContent()
                .stream()
                .map(x -> {
                    return mapper.map(x, MemberDto.class);
                })
                .collect(Collectors.toList());

        ApplyForMeResponse response = new ApplyForMeResponse();
        response.setContent(results);
        response.setPageNo(members.getNumber());
        response.setPageSize(members.getSize());
        response.setTotalElements(members.getTotalElements());
        response.setTotalPages(members.getTotalPages());
        response.setLast(members.isLast());
        return response;
    }

    @Override
    public ApplicantDetailsResponse getOne(Long id) {
        Member member = memberRepository.getOne(id);

        if (member == null) {
            throw new MemberNotFoundException(id);
        }

        Professional professional = professionalJpaRepository.getProfessional(id);
        professional.setMember(null);
        professional.setSubmissions(null);
        professional.setProfessionalProfiles(null);

        ApplicantDetailsResponse response = ApplicantDetailsResponse.builder()
                .membership(member)
                .professional(professional)
                .build();

        return response;
    }

    @Override
    public Member getOneMember(Long id) {
        Member member = memberRepository.getOne(id);

        if (member == null) {
            throw new MemberNotFoundException(id);
        }

        return member;
    }

    @Override
    public RecruiterStats getRecruiterStats() {
        var authenticatedUser = CurrentUserUtil.getCurrentUser();
        Long memberId = authenticatedUser.getId();
        RecruiterStats recruiterStats = new RecruiterStats();
        Long totalApplications = jobSubmissionRepository.countAllSubmissions();
        Long appliedJobs = jobSubmissionRepository.countAllSubmissionByApplier(memberId);
        recruiterStats.setTotalApplications(totalApplications);
        recruiterStats.setAppliedJobs(appliedJobs);
        return recruiterStats;
    }
}
