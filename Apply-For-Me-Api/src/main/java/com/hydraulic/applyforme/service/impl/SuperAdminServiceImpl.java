package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.model.dto.admin.UpdatePasswordDto;
import com.hydraulic.applyforme.model.dto.admin.UpdateProfileDto;
import com.hydraulic.applyforme.model.enums.RoleType;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.model.exception.PasswordMismatchException;
import com.hydraulic.applyforme.model.exception.RoleNotFoundException;
import com.hydraulic.applyforme.repository.CountryRepository;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.jpa.RoleJpaRepository;
import com.hydraulic.applyforme.repository.jpa.SuperAdminJpaRepository;
import com.hydraulic.applyforme.service.SuperAdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Validated
@Service
public class SuperAdminServiceImpl implements SuperAdminService {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private SuperAdminJpaRepository adminJpaRepository;
    private MemberRepository repository;
    private CountryRepository countryRepository;
    private RoleJpaRepository roleJpaRepository;


    public SuperAdminServiceImpl(SuperAdminJpaRepository adminJpaRepository,
                                 MemberRepository repository,
                                 CountryRepository countryRepository,
                                 RoleJpaRepository roleJpaRepository) {
        this.repository = repository;
        this.countryRepository = countryRepository;
        this.roleJpaRepository = roleJpaRepository;
        this.adminJpaRepository = adminJpaRepository;
    }


    @Override
    @Transactional
	public Member updatePassword(Long id, UpdatePasswordDto dto) throws PasswordMismatchException {
		Member member = repository.getOne(id);
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
    public Member updateProfile(Long id, UpdateProfileDto body) {

        Member superAdmin = repository.getOne(id);
        if (superAdmin == null) {
            throw new MemberNotFoundException(id);
        }

        superAdmin.setFirstName(body.getFirstName());
        superAdmin.setLastName(body.getLastName());
        superAdmin.setUsername(body.getUsername());
        return repository.updateOne(superAdmin);
//        Optional<Role> existingRole = roleJpaRepository.findByCode(RoleType.SUPER_ADMINISTRATOR.getValue());
//        if (existingRole.isEmpty()) {
//            throw new RoleNotFoundException(RoleType.SUPER_ADMINISTRATOR.getValue());
//        }

//        Member existing;
//
//        existing = mapper.map(body, Member.class);
//        existing.setPassword(superAdmin.getPassword());
//        existing.getRoles().add(existingRole.get());
//        existing.setNationality(countryRepository.getOne(body.getNationality()));
//        existing.setCountryOfResidence(countryRepository.getOne(body.getCountryOfResidence()));
//        return repository.updateOne(existing);
    }
}
