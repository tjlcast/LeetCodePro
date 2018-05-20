package com.tjlcast.websocketpushinfo.package1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @MessageMapping("/change-notice") // send 地址 value 为发送数据
    public void greeting(String value) {    // for socket
        System.out.println("================ " + value) ;
        this.simpMessagingTemplate.convertAndSend("/topic/notice", value);
    }

    @SubscribeMapping("/app_subscribe") // SubscribeMapping注解返回的消息直接发送到 client，不经过代理，而 @SendTo 注解的路径，就会经过代理，然后再发送到 目的地
    public String app_subscribe() {
        System.out.println("================ a subscribe") ;
        return "this is a subscribe" ;
    }

    @RequestMapping(path="/feed", method= RequestMethod.POST)
    public void greet(
            @RequestParam String greeting) {
        String text = "you said just now " + greeting;
        this.simpMessagingTemplate.convertAndSend("/topic/feed", text);
    }

    @Autowired
    SpittleFeedService spittleFeedService ;

    @RequestMapping(path= "/test", method = RequestMethod.GET)
    @ResponseBody
    public void hello() {
        Author tjlcast = new Author("tjlcast", 12);
        Spittle spittle = new Spittle("tjl's obj", tjlcast, 10);
        spittleFeedService.broadcastSpittle(spittle);
    }



}
