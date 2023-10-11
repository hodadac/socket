package com.example.demo.controller.member.dto;

import com.example.demo.repository.member.entity.Member;
import lombok.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MemberRequestDto {
    private String email;
    private String password;
    private String name;
    private String phoneNumber;


    public Member toEntity() {
        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .phoneNumber(phoneNumber)
                .build();
    }
}
