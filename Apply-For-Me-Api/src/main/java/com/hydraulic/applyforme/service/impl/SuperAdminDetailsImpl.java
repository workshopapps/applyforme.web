package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.security.UserDetailsImpl;
import com.hydraulic.applyforme.service.SuperAdminService;
import com.hydraulic.applyforme.service.superadmin.SuperAdminDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class SuperAdminDetailsImpl implements SuperAdminDetailsService {

    private Long id;

    public SuperAdminDetailsImpl(Long id) {
        this.id = id;
    }

    public static SuperAdminDetailsImpl build(Member member) {
        List<GrantedAuthority> authorities = member.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getCode()))
                .collect(Collectors.toList());

        return new SuperAdminDetailsImpl(member.getId());
    }

    @Override
    public Long getUserId() {
        return id;
    }
}
