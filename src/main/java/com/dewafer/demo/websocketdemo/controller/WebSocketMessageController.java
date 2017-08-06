package com.dewafer.demo.websocketdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class WebSocketMessageController {

    @MessageMapping("/from-client")
    public void fromClient(String content) {
        log.info("Message from client: {}", content);
    }
}
