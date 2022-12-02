package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.admin.UpdatePasswordDto;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.model.exception.PasswordMismatchException;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.repository.jpa.RoleJpaRepository;
import com.hydraulic.applyforme.repository.jpa.SuperAdminJpaRepository;
import com.hydraulic.applyforme.service.SuperAdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    
    @Override
    @Transactional(readOnly = true)
    public Member getDetails(Long id) {
        Member member = repository.getOne(id);

        if (member == null) {
            throw new MemberNotFoundException(id);
        }
        return member;
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
//        boolean removed = repository.remove(id);
//        if(removed){
//            return true;
//        }
//        else {
//            throw new MemberNotFoundException(id);
//        }
    }

    
}
