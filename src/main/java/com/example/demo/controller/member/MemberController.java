package com.example.demo.controller.member;

import com.example.demo.controller.Auth.component.JwtTokenProvider;
import com.example.demo.controller.member.dto.MemberRequestDto;
import com.example.demo.controller.member.dto.MemberResponseDto;
import com.example.demo.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping("/user")
    public ResponseEntity<?> findUser(@RequestHeader("Authorization") String accessToken) {
        Long id = this.jwtTokenProvider.getUserIdFromToken(accessToken.substring(7));
        MemberResponseDto userResponseDto = this.memberService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    /** 회원정보 수정 API */
    @PutMapping("/user")
    public ResponseEntity<?> updateUser(@RequestHeader("Authorization") String accessToken,
                                        @RequestBody MemberRequestDto requestDto) {
        Long id = this.jwtTokenProvider.getUserIdFromToken(accessToken.substring(7));
        this.memberService.update(id, requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    /** 회원정보 삭제 API */
    @DeleteMapping("/user")
    public ResponseEntity<?> deleteUser(@RequestHeader("Authorization") String accessToken) {
        Long id = this.jwtTokenProvider.getUserIdFromToken(accessToken.substring(7));
        this.memberService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}

