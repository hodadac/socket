package com.example.demo.controller.Auth.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequestDto {
    private String name;
    private String password;
}
