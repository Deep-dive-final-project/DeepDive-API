package org.deepdive.apiserver.security.config;

import org.deepdive.apiserver.security.application.fliter.JwtFilter;
import org.deepdive.apiserver.security.application.provider.JwtAuthenticationProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    public JwtSecurityConfig(JwtAuthenticationProvider jwtAuthenticationProvider) {
        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
    }

    @Override
    public void configure(HttpSecurity http) {
        JwtFilter jwtFilter = new JwtFilter(jwtAuthenticationProvider);
        http
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
