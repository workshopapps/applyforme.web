package com.hydraulic.applyforme.util;

import com.hydraulic.applyforme.model.response.SignInResponse;
import com.hydraulic.applyforme.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.beans.FeatureDescriptor;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.stream.Stream;

@Component
public class ApplyForMeUtil {

    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;


    public ApplyForMeUtil(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> {
                    try {
                        return Objects.isNull(wrappedSource.getPropertyValue(propertyName));
                    } catch (Exception e) {
                        return false;
                    }
                })
                .toArray(String[]::new);
    }

    public static String readResourceFile(String path) {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource(path);
        return asString(resource);
    }

    private static String asString(Resource resource) {
        try (Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static Pageable createPageable(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        return PageRequest.of(pageNo, pageSize, sort);
    }

    public SignInResponse generateSignInToken(String emailAddress) {
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(emailAddress);

        final String token = jwtUtil.generateToken(userDetails);
        final String refreshToken = jwtUtil.doGenerateRefreshToken(emailAddress);
        return new SignInResponse(token, refreshToken);
    }
}
