package com.tjlcast.websocketpushinfo;

import org.springframework.boot.SpringApplication ;
import org.springframework.boot.autoconfigure.SpringBootApplication ;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

/**
 * Created by tangjialiang on 2018/5/15.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class) ;
    }

//    @Bean
//    public MappingJackson2MessageConverter jackson2Converter() {
//        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
//        return converter;
//    }
}
