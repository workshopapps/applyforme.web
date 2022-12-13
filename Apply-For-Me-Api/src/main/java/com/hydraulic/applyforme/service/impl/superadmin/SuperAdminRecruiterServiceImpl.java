package com.hydraulic.applyforme.service.impl.superadmin;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.exception.RecruiterNotFoundException;
import com.hydraulic.applyforme.repository.ApplierRepository;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.jpa.SuperAdminRecruiterJpaRepository;
import com.hydraulic.applyforme.service.superadmin.SuperAdminApplicantService;
import com.hydraulic.applyforme.service.superadmin.SuperAdminRecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SuperAdminRecruiterServiceImpl implements SuperAdminRecruiterService {

    @Autowired
    private final SuperAdminApplicantService service;

    private final SuperAdminRecruiterJpaRepository repository;

    private final MemberRepository memberRepository;

    private final ApplierRepository applierRepository;


    public SuperAdminRecruiterServiceImpl(SuperAdminApplicantService service, SuperAdminRecruiterJpaRepository repository, MemberRepository memberRepository, ApplierRepository applierRepository) {
        this.service = service;
        this.repository = repository;
        this.memberRepository = memberRepository;
        this.applierRepository = applierRepository;
    }

    @Override
    public Member searchRecruitersByName(String firstName) {
        return repository.searchRecruiterByName(firstName);
    }


    @Transactional
    @Override
    public void deleteRecruiterById(Long id) {
            Member recruiter = memberRepository.getOne(id);

            if (recruiter != null) {boolean deleted = applierRepository.remove(recruiter.getId());
            }
            else {
                throw new RecruiterNotFoundException(id);
            }
        }

    }



