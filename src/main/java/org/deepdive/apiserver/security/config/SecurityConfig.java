package org.deepdive.apiserver.security.config;

import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.config.CorsConfig;
import org.deepdive.apiserver.security.handler.CustomLoginSuccessHandler;
import org.deepdive.apiserver.security.handler.CustomLoginFailureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CorsConfig corsConfig;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**").disable())
            .cors(cors -> cors.configurationSource(corsConfig.corsConfigurationSource()))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console/**").permitAll()
                .anyRequest().permitAll())
            .headers(AbstractHttpConfigurer::disable)
            .formLogin(form -> form
                .loginProcessingUrl("/api/auth/login")
                .successHandler(new CustomLoginSuccessHandler())
                .failureHandler(new CustomLoginFailureHandler()))
            .logout(logout -> logout
                .logoutUrl("/api/auth/logout")
                .logoutSuccessUrl("/"));

        return http.build();
    }
}
