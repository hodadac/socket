package com.example.demo.controller.member;

import com.example.demo.repository.member.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {
    private final Member user;

    public CustomUserDetails(Member member){
        this.user = member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole().name()));
    }

    public Long getId(){
        return user.getIdx();
    }

    public String getEmail(){
        return user.getEmail();
    }

    public String getContact(){
        return user.getContact();
    }
    @Override
    public String getUsername(){
        return user.getName();
    }
    @Override
    public String getPassword(){
        return user.getPassword();
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }

}
