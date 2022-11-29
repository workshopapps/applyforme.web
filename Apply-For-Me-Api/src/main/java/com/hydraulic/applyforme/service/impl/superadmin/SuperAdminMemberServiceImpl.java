package com.hydraulic.applyforme.service.impl.superadmin;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.service.superadmin.SuperAdminMemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SuperAdminMemberServiceImpl implements SuperAdminMemberService {

    private final MemberRepository repository;

    public SuperAdminMemberServiceImpl(MemberRepository repository) {
        this.repository = repository;
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
        }
        else {
            throw new MemberNotFoundException(id);
        }
    }
}
