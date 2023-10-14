package com.example.demo.controller.Auth;

import com.example.demo.controller.Auth.dto.AuthRequestDto;
import com.example.demo.controller.Auth.dto.AuthResponseDto;
import com.example.demo.controller.member.dto.MemberRequestDto;
import com.example.demo.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AuthRestController {
    private final AuthService authService;

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDto requestDto) {
        System.out.print(requestDto.getPassword());
        AuthResponseDto responseDto = this.authService.login(requestDto);
        System.out.print(responseDto.getAccessToken());
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    /** 회원가입 API */
    @PostMapping("/auth/signup")
    public ResponseEntity<?> singUp(@RequestBody MemberRequestDto requestDto) {
        System.out.print(requestDto.getPassword());
        this.authService.signup(requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    /** 토큰갱신 API */
    @GetMapping("/auth/refresh")
    public ResponseEntity<?> refreshToken(@RequestHeader("REFRESH_TOKEN") String refreshToken) {
        String newAccessToken = this.authService.refreshToken(refreshToken);
        return ResponseEntity.status(HttpStatus.OK).body(newAccessToken);
    }

}
