package com.tjlcast.websocketpushinfo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Created by tangjialiang on 2018/5/16.
 * https://blog.csdn.net/zhangdehua678/article/details/78913839
 *
 * 服务器主动推送，由服务端来触发
 */

//@Configuration
public class package2_config {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter() ;
    }
}
