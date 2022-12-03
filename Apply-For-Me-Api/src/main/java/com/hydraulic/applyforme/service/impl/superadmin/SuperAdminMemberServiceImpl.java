package com.hydraulic.applyforme.service.impl.superadmin;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.jpa.SuperAdminMemberJpaRepository;
import com.hydraulic.applyforme.service.superadmin.SuperAdminMemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.hydraulic.applyforme.util.ApplyForMeUtil.createPageable;

@Service
public class SuperAdminMemberServiceImpl implements SuperAdminMemberService {

    private final MemberRepository repository;
    private final SuperAdminMemberJpaRepository jpaRepository;

    public SuperAdminMemberServiceImpl(MemberRepository repository, SuperAdminMemberJpaRepository jpaRepository) {
        this.repository = repository;
        this.jpaRepository = jpaRepository;
    }

    @Transactional(readOnly = true)
    public Member getOne(Long id) {
        return repository.getOne(id);
    }

    @Override
    @Transactional
    public boolean deleteMember(Long id) {
        boolean removed = repository.remove(id);
        if (removed) {
            return true;
        } else {
            throw new MemberNotFoundException(id);
        }
    }

    @Override
    public ApplyForMeResponse viewAllRecruiters(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        var result = jpaRepository.getAllMembers(pageable);
        ApplyForMeResponse applyForMeResponse = new ApplyForMeResponse();
        applyForMeResponse.setContent(result.getContent());
        applyForMeResponse.setPageNo(result.getNumber());
        applyForMeResponse.setPageSize(result.getSize());
        applyForMeResponse.setTotalElements(result.getTotalElements());
        applyForMeResponse.setTotalPages(result.getTotalPages());
        applyForMeResponse.setLast(result.isLast());
        return applyForMeResponse;
    }


}

