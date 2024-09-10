package org.deepdive.apiserver.security.application.service;

import lombok.RequiredArgsConstructor;
import org.deepdive.apiserver.security.application.interfaces.MemberRepository;
import org.deepdive.apiserver.security.application.service.CustomUserDetails;
import org.deepdive.apiserver.security.domain.Member;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email);
        return new CustomUserDetails(member);
    }

    public CustomUserDetails loadUserByUserId(Long id) {
        Member member = memberRepository.findById(id);
        return new CustomUserDetails(member);
    }
}
