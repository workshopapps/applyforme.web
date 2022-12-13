package com.hydraulic.applyforme.config.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hydraulic.applyforme.model.exception.ExpiredJwtToken;
import com.hydraulic.applyforme.model.security.UserDetailsImpl;
import com.hydraulic.applyforme.service.impl.UserDetailsServiceImpl;
import com.hydraulic.applyforme.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String tokenHeader = request.getHeader("Authorization");
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (header == null || !StringUtils.startsWith(tokenHeader,"Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        System.out.println("header " + header);

        final String token = header.substring(7);
        String emailAddress = null;

        try {
            emailAddress = jwtUtil.getUsernameFromToken(token);
        } catch (IllegalArgumentException e) {
            System.out.println("Unable to get JWT Token");
        } catch (ExpiredJwtException e) {
            resolver.resolveException(request, response, null, e);
            return;
        } catch (MalformedJwtException e) {
            resolver.resolveException(request, response, null, e);
            return;
        } catch (SignatureException e) {
            resolver.resolveException(request, response, null, e);
            return;
        }

        if (!StringUtils.isNotEmpty(emailAddress)) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            System.out.println(SecurityContextHolder.getContext().getAuthentication());
            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = UserDetailsImpl.buildFromTokenDetails(jwtUtil.getDetails(token));

                if (jwtUtil.validateToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetails,
                                    null,
                                    userDetails.getAuthorities());
                    authentication
                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e);
        }

        filterChain.doFilter(request, response);
    }
}
