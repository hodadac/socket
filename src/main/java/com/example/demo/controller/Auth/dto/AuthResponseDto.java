package com.example.demo.controller.Auth.dto;

import com.example.demo.repository.auth.entity.Auth;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDto {
    private String tokenType;
    private String accessToken;
    private String refreshToken;

    @Builder
    public AuthResponseDto(Auth auth){
        this.tokenType = auth.getTokenType();
        this.accessToken = auth.getAccessToken();
        this.refreshToken = auth.getRefreshToken();
    }

}
