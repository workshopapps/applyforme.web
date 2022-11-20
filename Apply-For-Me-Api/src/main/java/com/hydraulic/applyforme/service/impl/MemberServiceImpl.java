package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.model.dto.signup.SignUpDto;
import com.hydraulic.applyforme.model.enums.RoleType;
import com.hydraulic.applyforme.model.exception.EmailAlreadyExistsException;
import com.hydraulic.applyforme.model.exception.RoleNotFoundException;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.repository.jpa.RoleJpaRepository;
import com.hydraulic.applyforme.service.MemberService;
import lombok.extern.slf4j.Slf4j;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private ModelMapper modelMapper;

    private final MemberJpaRepository repository;

    private final RoleJpaRepository roleJpaRepository;

    private final PasswordEncoder passwordEncoder;

    public MemberServiceImpl(MemberJpaRepository repository, RoleJpaRepository roleJpaRepository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.roleJpaRepository = roleJpaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public Member save(SignUpDto body) {
        boolean existingMember = repository.existsByEmailAddress(body.getEmailAddress());

        if (existingMember) {
            throw new EmailAlreadyExistsException();
        }

        Optional<Role> existingRole = roleJpaRepository.findByCode(RoleType.RECRUITER.getValue());

        if (existingRole.isEmpty()) {
            throw new RoleNotFoundException(RoleType.RECRUITER.getValue());
        }

        Member member = new Member();
        member = modelMapper.map(body, Member.class);
        member.setPassword(passwordEncoder.encode(body.getPassword()));
        member.addRole(existingRole.get());
        return repository.save(member);
    }

    //sign-in logic
    @Override
    public UserDetails loadMemberByUsername(String username) throws UsernameNotFoundException {

        Member member = repository.findByEmail(username);   //retrieve member object
        if(member == null){
            throw new UsernameNotFoundException("Invalid email address or password.");
        }

        //use user class from spring security
        return new org.springframework.security.core.userdetails.User(member.getEmailAddress(), member.getPassword(), mapRolesToAuthorities(member.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getTitle())).collect(Collectors.toList());

    }
}
