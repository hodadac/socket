package com.example.demo.service.member;

import com.example.demo.controller.member.dto.MemberRequestDto;
import com.example.demo.controller.member.dto.MemberResponseDto;
import com.example.demo.repository.member.MemberRepository;
import com.example.demo.repository.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImp implements MemberService{
    private final MemberRepository memberRepository;

    @Override
    public MemberResponseDto findBy(MemberRequestDto params) {
        Member loginMember = params.toEntity();
        return new MemberResponseDto(memberRepository.findByEmailAndPassword(loginMember.getEmail(), loginMember.getPassword()));
    }

    @Override
    public String signUpMember(MemberRequestDto params) {
        try{
            memberRepository.save(params.toEntity());
            return "success";
        }catch (Exception e){
            return "error";
        }
    }
}
