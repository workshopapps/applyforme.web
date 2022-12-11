package com.hydraulic.applyforme.config.security;

import com.hydraulic.applyforme.config.filter.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration {

    @Autowired
    private JwtAuthEntryPoint authEntryPoint;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenFilter tokenFilter;

    @Autowired
    private JwtAuthenticationProvider authenticationProvider;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/api/v1/auth/**").permitAll()
                .anyRequest().permitAll()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
        http
                .headers()
                .frameOptions()
                .sameOrigin();

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web
                .ignoring()
                .antMatchers("/swagger-ui.html", "/swagger-ui/**",
                                        "/swagger-resources/**", "swagger-ui.html/**",
                                        "/v2/api-docs", "/v3/api-docs", "/v1/api-docs",
                                        "/v3/api-docs/**", "/v2/api-docs/**", "/v1/api-docs/**",
                                        "/configuration/ui", "/configuration/**",
                                        "/webjars/**",
                                        "/api/v1/swagger-ui.html", "/api/v1/swagger-ui/**", "/api/v1/swagger-resources/**",
                                        "/api/v1swagger-ui.html/**", "/api/v1/v2/api-docs", "/api/v1/v3/api-docs",
                                        "/api/v1/v1/api-docs", "/api/v1/v3/api-docs/**", "/api/v1/v2/api-docs/**",
                                        "/api/v1/v1/api-docs/**", "/api/v1/configuration/ui", "/api/v1/configuration/**",
                                        "/api/v1/webjars/**");
    }

    @Bean
    public AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        authenticationManagerBuilder.authenticationProvider(authenticationProvider);
        return authenticationManagerBuilder.build();
    }

}
