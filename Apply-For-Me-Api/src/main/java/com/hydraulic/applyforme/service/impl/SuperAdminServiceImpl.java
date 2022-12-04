package com.hydraulic.applyforme.service.impl;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.admin.UpdatePasswordDto;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.model.exception.PasswordMismatchException;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.repository.jpa.RoleJpaRepository;
import com.hydraulic.applyforme.repository.jpa.SuperAdminJpaRepository;
import com.hydraulic.applyforme.service.SuperAdminService;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {
    
    private MemberRepository repository;

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private MemberJpaRepository memberJpaReposiroty;
    @Autowired
    private RoleJpaRepository roleJpaRepository;
    
    @Autowired
    private SuperAdminJpaRepository jpaRepository;
    
    public SuperAdminServiceImpl(MemberRepository repository) {
        this.repository = repository;
    }
    
	@Override
    @Transactional
	public Member updatePassword(Long id, UpdatePasswordDto dto) throws PasswordMismatchException {
		Member member = jpaRepository.getById(id);
		System.out.println(member);
		boolean matches = passwordEncoder.matches(dto.getExistingPassword(), member.getPassword());
		
        if (!matches) {
			throw new PasswordMismatchException();
		}
        
        member.setPassword(passwordEncoder.encode(dto.getNewPassword()));
		return repository.updateOne(member);		
	}

    @Transactional(readOnly = true)
    public Member getProfileDetails(Long id) {
        Member member = repository.getOne(id);
        return member;
    }

    @Override
    public Member getDetailsById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public boolean deleteMemberById(Long id) {
    	Member member = memberJpaReposiroty.getById(id);
    	if(member == null) {
    		throw new MemberNotFoundException(id);
    	}
    	memberJpaReposiroty.delete(member);
    	
    	return true;
    }

    @Override
    public Member getAdmin(Long id) {
        return null;
    }



}
