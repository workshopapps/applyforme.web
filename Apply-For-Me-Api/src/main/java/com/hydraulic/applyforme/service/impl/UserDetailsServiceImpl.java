package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.security.UserDetailsImpl;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;

@Component
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

    MemberJpaRepository repository;

    public UserDetailsServiceImpl(MemberJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
        Member member = repository.findByEmailAddress(emailAddress);

        if (member == null) {
            throw new UsernameNotFoundException(emailAddress);
        }
        return UserDetailsImpl.build(member);
    }
}
