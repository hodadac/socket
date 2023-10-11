package com.example.demo.controller.memo.dto;

import com.example.demo.repository.memo.entity.Memo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemoRequestDto {
    private String memberId;
    private String content;

    public Memo toEntity(){
        return Memo.builder()
                .memberId(memberId)
                .content(content)
                .build();
    }


}
