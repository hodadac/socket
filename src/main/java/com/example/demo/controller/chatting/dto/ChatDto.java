package com.example.demo.controller.chatting.dto;

import lombok.Data;

@Data
public class ChatDto {
    private Integer channelId;
    private Integer writerId;
    private String chat;
}
