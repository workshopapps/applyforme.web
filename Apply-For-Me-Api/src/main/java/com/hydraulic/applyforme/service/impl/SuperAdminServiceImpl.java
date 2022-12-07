package com.hydraulic.applyforme.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.admin.UpdatePasswordDto;
import com.hydraulic.applyforme.model.dto.admin.UpdateProfileDto;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.model.exception.PasswordMismatchException;
import com.hydraulic.applyforme.repository.ApplierRepository;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.repository.jpa.SuperAdminJpaRepository;
import com.hydraulic.applyforme.service.SuperAdminService;

@Validated
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
    private ApplierRepository applierRepository;
    
    @Autowired
    private SuperAdminJpaRepository jpaRepository;
    
    public SuperAdminServiceImpl(MemberRepository repository) {
        this.repository = repository;
    }


    @Override
    @Transactional
	public Member updatePassword(Long id, UpdatePasswordDto dto) throws PasswordMismatchException {
		Member member = repository.fetchOne(id);
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
    @Transactional
    public Member updateProfile(Long id, UpdateProfileDto body) {

        Member superAdmin = repository.getOne(id);
        if (superAdmin == null) {
            throw new MemberNotFoundException(id);
        }

        superAdmin.setFirstName(body.getFirstName());
        superAdmin.setLastName(body.getLastName());
        superAdmin.setUsername(body.getUsername());
        superAdmin.setDateOfBirth(body.getDateOfBirth());
        superAdmin.setCurrentJobTitle(body.getCurrentJobTitle());
        superAdmin.setEmailAddress(body.getEmailAddress());
        superAdmin.setPhoneNumber(body.getPhoneNumber());
        superAdmin.setCity(body.getCity());
        superAdmin.setState(body.getState());
        superAdmin.setNationality(Country.builder().id(body.getNationality()).title(body.getNationTitle()).abbreviation(body.getNationAbbreviation()).build());
        superAdmin.setCountryOfResidence(Country.builder().id(body.getCountryOfResidence()).title(body.getCountryTitle()).abbreviation(body.getCountryAbbreviation()).build());
        return repository.updateOne(superAdmin);
    }

    public Member getDetailsById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public boolean deleteMemberById(Long id) {
//    	  Member member = repository.fetchOne(id);
//    	System.out.println(member);
//    	if(member == null) {
//    		throw new MemberNotFoundException(id);
//    	}
//    	repository.remove(member.getId());
    	
    	applierRepository.remove(id);
    	return true;
    }

    @Override
    public Member getAdmin(Long id) {
        return null;
    }

}
