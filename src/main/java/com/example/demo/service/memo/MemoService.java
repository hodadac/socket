package com.example.demo.service.memo;

import com.example.demo.controller.memo.dto.MemoRequestDto;
import com.example.demo.controller.memo.dto.MemoResponseDto;
import com.example.demo.repository.memo.entity.Memo;

import java.util.List;

public interface MemoService {
    List<Memo> memberMemo(MemoRequestDto params);
    String memoInsert(MemoRequestDto params);

}
