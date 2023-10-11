package com.example.demo.controller.memo.dto;

import com.example.demo.repository.memo.entity.Memo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemoResponseDto {
    private Long memoIdx;
    private String memberId;
    private String content;

    public MemoResponseDto(Memo memo){
        this.memoIdx = memo.getMemoIdx();
        this.memberId = memo.getMemberId();
        this.content = memo.getContent();
    }

}
