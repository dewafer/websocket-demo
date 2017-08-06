package com.dewafer.demo.websocketdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class TickService {

    @SendTo("/global-message/tick")
    @Scheduled(fixedDelay = 1000)
    public String tick() {
        String currentTime = DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now());
        log.info("Message send to client: {}", currentTime);
        return currentTime;
    }
}
