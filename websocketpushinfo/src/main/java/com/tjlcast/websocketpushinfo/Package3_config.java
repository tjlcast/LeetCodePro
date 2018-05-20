package com.tjlcast.websocketpushinfo;

import com.tjlcast.websocketpushinfo.package3.EchoEndPoint;
import com.tjlcast.websocketpushinfo.package3.EchoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Created by tangjialiang on 2018/5/17.
 */

@Configuration
public class Package3_config {

    @Bean
    public EchoEndPoint echoEndPoint() {
        return new EchoEndPoint(echoService()) ;
    }

    @Bean
    public EchoService echoService() {
        return new EchoService() ;
    }

    @Bean
    public ServerEndpointExporter endpointExporter() {
        return new ServerEndpointExporter() ;
    }
}
