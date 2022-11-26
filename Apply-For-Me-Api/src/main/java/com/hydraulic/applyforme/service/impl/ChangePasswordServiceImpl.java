package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.password.ChangePasswordDto;
import com.hydraulic.applyforme.model.exception.InvalidOldPasswordException;
import com.hydraulic.applyforme.repository.jpa.PasswordJpaRepository;
import com.hydraulic.applyforme.service.ChangePasswordService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static java.util.regex.Pattern.matches;

@Slf4j
@Service
public class ChangePasswordServiceImpl implements ChangePasswordService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final PasswordJpaRepository jpaRepository;

    public ChangePasswordServiceImpl(PasswordJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    @Transactional
    public boolean checkIfValidOldPassword(Member member, String oldPassword) {
        return matches(oldPassword, member.getPassword());
    }

    @Override
    @Transactional
    public Member changePassword(Long id, ChangePasswordDto password) {
        final Member member = jpaRepository.findById(id);

        Member mapper = new Member();
        mapper = modelMapper.map(id, Member.class);

        if (checkIfValidOldPassword(member, member.getPassword())){
            if (password.getNewPassword().equals(password.getReNewPassword())) {
                member.setPassword(password.getNewPassword());
                jpaRepository.save(member);
            }
        }else{
            throw new  InvalidOldPasswordException();
        }

    return member;

    }


}
