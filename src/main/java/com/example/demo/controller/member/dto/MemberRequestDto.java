package com.example.demo.controller.member.dto;

import com.example.demo.repository.member.entity.Member;
import com.example.demo.repository.member.entity.Role;
import lombok.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MemberRequestDto {
    private String email;
    private String password;
    private String name;
    private String contact;
    private String phoneNumber;
    private Role role;

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .contact(contact)
                .phoneNumber(phoneNumber)
                .role(role)
                .build();
    }
}
