package com.example.demo.controller.member.dto;

import com.example.demo.repository.member.entity.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberResponseDto {

    private Long idx;
    private String email;
    private String name;
    private String password;
    private String phoneNumber;

    public MemberResponseDto(Member member){
        this.idx=member.getIdx();
        this.name=member.getName();
    }
}
