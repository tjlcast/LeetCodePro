package com.tjlcast.websocketpushinfo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by tangjialiang on 2018/5/16.
 */

@Controller
public class GreetingController {

    @Resource
    private SimpMessagingTemplate simpMessagingTemplate ;

    @RequestMapping("/helloSocket") // for http
    public String index() {
        return "/hello/index" ;
    }

    @MessageMapping("/change-notice")
    public void greeting(String value) {    // for socket
        this.simpMessagingTemplate.convertAndSend("/topic/notice", value);
    }
}
