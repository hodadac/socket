package com.example.demo.service.member;

import com.example.demo.controller.member.CustomUserDetails;
import com.example.demo.repository.member.MemberRepository;
import com.example.demo.repository.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException{
        Member member = memberRepository.findByName(name).orElseThrow(
                () -> new UsernameNotFoundException("해당 유저가 존재하지 않습니다. username =" + name));
        return new CustomUserDetails(member);
    }

    public UserDetails loadUserByUserId(Long idx) throws IllegalArgumentException{
        Member member = memberRepository.findById(idx).orElseThrow(
                () -> new IllegalArgumentException("해당 유저가 존재하지 않습니다. userid =" + idx));
        return new CustomUserDetails(member);
    }

    public UserDetails loadUserByEmail(String email) throws IllegalArgumentException {
        Member member = memberRepository.findByEmail(email).orElseThrow(
                () -> new IllegalArgumentException("해당 유저가 존재하지 않습니다. email = " + email));
        return new CustomUserDetails(member);
    }


}
