package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.model.dto.member.MemberDto;
import com.hydraulic.applyforme.model.enums.RoleType;
import com.hydraulic.applyforme.model.exception.MemberDuplicateEntityException;
import com.hydraulic.applyforme.model.dto.admin.UpdatePasswordDto;
import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
import com.hydraulic.applyforme.model.exception.PasswordMismatchException;
import com.hydraulic.applyforme.repository.MemberRepository;
import com.hydraulic.applyforme.repository.SuperAdminRepository;
import com.hydraulic.applyforme.service.SuperAdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {
    
    private MemberRepository repository;

    private SuperAdminRepository adminRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public SuperAdminServiceImpl(MemberRepository repository, SuperAdminRepository adminRepository) {
        this.repository = repository;
        this.adminRepository = adminRepository;
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
    public Member getDetails(Long id) {
        return null;
    }

//    @Override
//    @Transactional(readOnly = true)
//    public Member getDetails(Long id) {
//        Member member = repository.getOne(id);
//
//        if (member == null) {
//            throw new MemberNotFoundException(id);
//        }
//        return member;
//    }

    @Override
    public Member getDetailsById(Long id) {
        return null;
    }

    @Override
    public boolean deleteMemberById(Long id) {
        return false;
    }

    @Override
    public Member getAdmin(Long id) {
        return null;
    }

    @Override
    public List<Applier> viewAllRecruiters() {
        return adminRepository.getAllMembers();
    }

    @Override
    public Member createRecruiter(MemberDto memberDto) {
        return null;
    }


//    @Override
//    public Member createRecruiter(MemberDto memberDto) {
//
//        Optional<Role> existingRole = roleJpaRepository.findByCode(RoleType.RECRUITER.getValue());
//
//        Member member = jpaRepository.findMemberByRoles(existingRole);
//        if(member==null){
//            Member newMember = mapper.map(memberDto,Member.class);
//            return repository.saveOne(newMember);
//        }
//        throw new MemberDuplicateEntityException();
//    }

}
