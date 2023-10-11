package com.example.demo.controller.memo;

import com.example.demo.controller.memo.dto.MemoRequestDto;
import com.example.demo.repository.memo.entity.Memo;
import com.example.demo.service.memo.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/memo")
@CrossOrigin(origins = "*")
public class MemoController {

    private final MemoService memoService;
    @PostMapping("")
    public List<Memo> memoList(@RequestBody MemoRequestDto params){
        return memoService.memberMemo(params);
    }

    @PostMapping("/insert")
    public String memoInsert(@RequestBody MemoRequestDto params){
        return  memoService.memoInsert(params);
    }

    @GetMapping("")
    public String pythonExecute() throws IOException, InterruptedException {

        ProcessBuilder builder = new ProcessBuilder();
        builder.command("cmd.exe","/c","cd demo&python hello.py ");

        Process process = builder.start();
        BufferedReader br = new BufferedReader(new InputStreamReader( process.getInputStream(),"euc-kr"));

        String line = br.readLine();
        process.waitFor();
        process.destroy();
        System.out.println(line);
        return line;
    }

}
