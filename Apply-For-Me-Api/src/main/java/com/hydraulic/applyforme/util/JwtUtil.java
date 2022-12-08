package com.hydraulic.applyforme.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.model.dto.authentication.JwtTokenDetails;
import com.hydraulic.applyforme.model.security.UserDetailsImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;

@Slf4j
@Component
@Getter
@Setter
@PropertySource("classpath:application.properties")
public class JwtUtil {
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    @Value("${applyforme.jwt.secret}")
    private String secret;

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

   public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public Map<String, Object> getTokenDetails(String token) {
        return new HashMap<>(getAllClaimsFromToken(token));
    }

    public JwtTokenDetails getDetails(String token) {
        ObjectMapper mapper = new ObjectMapper();
        JwtTokenDetails details = mapper.convertValue(getTokenDetails(token), JwtTokenDetails.class);
        return details;
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        UserDetailsImpl userDetails1 = (UserDetailsImpl) userDetails;

        String[] roles = userDetails1.getPlainRoles()
                    .stream()
                    .map(Role::getCode)
                    .toArray(String[]::new);

        claims.put("memberId", userDetails1.getId());
        claims.put("roles", roles);
        claims.put("fullName", userDetails1.getFullName());
        claims.put("emailAddress", userDetails1.getEmailAddress());
        claims.put("username", userDetails1.getDisplayName());
        claims.put("avatar", userDetails1.getAvatar());
        claims.put("phoneNumber", userDetails1.getPhoneNumber());
        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public Boolean validateToken(String token, UserDetails details) {
        final String username = getUsernameFromToken(token);
        return (username.equals(details.getUsername()) && !isTokenExpired(token));
    }

    private void setMemberType(UserDetails userDetails, Map<String, Object> claimsMap) {
        UserDetailsImpl details = (UserDetailsImpl) userDetails;
        String memberType = null;
        for (Role role : details.getPlainRoles()) {
            if (role.getCode().equals("SuperAdministrator")) {
                memberType = role.getCode();
                break;
            }
            else if (role.getCode().equals("Administrator")) {
                memberType = role.getCode();
                break;
            }
            else if (role.getCode().equals("Recruiter")) {
                memberType = role.getCode();
                break;
            }
            else if (role.getCode().equals("Professional")) {
                memberType = role.getCode();
                break;
            }
        }
        claimsMap.put("memberType", memberType);
    }

}
