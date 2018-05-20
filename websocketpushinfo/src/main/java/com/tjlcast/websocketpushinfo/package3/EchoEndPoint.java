package com.tjlcast.websocketpushinfo.package3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by tangjialiang on 2018/5/17.
 */

@ServerEndpoint(value = "/echo", configurator = SpringConfigurator.class)
public class EchoEndPoint {

    private final EchoService echoService ;

    @Autowired
    public EchoEndPoint(EchoService echoService) {
        this.echoService = echoService ;
    }

    @OnMessage
    public void handleMessage(Session session, String message) {
        System.out.println("=========" + message) ;
    }
}
