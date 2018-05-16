package com.tjlcast.websocketpushinfo;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by tangjialiang on 2018/5/16.
 * https://www.jianshu.com/p/60799f1356c5
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 添加一个服务端点，来接受客户端的连接
        registry.addEndpoint("/socket").withSockJS() ; // 添加一个/socket端点(客户端通过这个端点进行连接)，并开启SockJS
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 设置消息连接请求的各种规范
        registry.setApplicationDestinationPrefixes("/app") ; // 服务端接收地址的前缀
        registry.enableSimpleBroker("/topic") ; // 表示客户端接收服务端消息的地址的前缀信息
    }
}
