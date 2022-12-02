package com.hydraulic.applyforme.util;

import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.service.superadmin.SuperAdminDetailsService;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class CurrentUserUtil {

    MemberJpaRepository repository;

    public static SuperAdminDetailsService getCurrentUser() {
        final SecurityContext context = SecurityContextHolder.getContext();
        final Authentication authentication = context.getAuthentication();

        try {
            return authentication != null && authentication.isAuthenticated() ? (SuperAdminDetailsService) authentication
                    .getPrincipal() : null;
        } catch (ClassCastException e) {
            throw new AuthenticationServiceException(e.getLocalizedMessage(), e);
        }
    }

    public static Long getCurrentUserId() {
        return getCurrentUser().getUserId();
    }
//
//
//
//    public static boolean isAdmin() {
//        return getCurrentUser().isAdmin();
//    }
}
