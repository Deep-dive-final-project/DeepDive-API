package org.deepdive.apiserver.security.application.provider;


import static org.deepdive.apiserver.common.exception.ErrorCode.FAILURE_LOGIN;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.common.exception.CommonException;
import org.deepdive.apiserver.security.application.service.CustomUserDetails;
import org.deepdive.apiserver.security.application.service.CustomUserDetailsService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SimpleAuthenticationProvider implements AuthenticationProvider {

    private final CustomUserDetailsService customUserDetailsService;
    private final PasswordEncoder passwordEncoder;

    /**
     * request 정보의 authentication 이용해 인증 정보를 가진 authentication 생성
     */
    @Override
    public Authentication authenticate(Authentication authentication)
        throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        // nickname 검증은 userDetailsService에서 진행
        CustomUserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

        // password 검증은 passwordEncoder가 진행
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new CommonException(FAILURE_LOGIN);
        }

        // principal을 갖는 authentication 생성
        return new UsernamePasswordAuthenticationToken(userDetails, null,
            List.of(new SimpleGrantedAuthority("ROLE_USER")));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
