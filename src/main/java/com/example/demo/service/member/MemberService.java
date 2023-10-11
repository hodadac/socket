package com.example.demo.service.member;

import com.example.demo.controller.member.dto.MemberRequestDto;
import com.example.demo.controller.member.dto.MemberResponseDto;

public interface MemberService{
    MemberResponseDto findBy(MemberRequestDto params);
    String signUpMember(MemberRequestDto params);
}
