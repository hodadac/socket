package com.example.demo.controller.member;

import com.example.demo.controller.member.dto.MemberRequestDto;
import com.example.demo.controller.member.dto.MemberResponseDto;
import com.example.demo.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/login")
    public MemberResponseDto login(@RequestBody MemberRequestDto params) {
        return memberService.findBy(params);
    }
    @PostMapping("/signUp")
    public String signUp(@RequestBody MemberRequestDto params){
        return memberService.signUpMember(params);
    }

}

