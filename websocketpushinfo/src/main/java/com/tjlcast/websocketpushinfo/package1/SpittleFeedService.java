package com.tjlcast.websocketpushinfo.package1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

/**
 * Created by tangjialiang on 2018/5/17.
 */
@Service
public class SpittleFeedService {
    @Autowired
    SimpMessageSendingOperations message ;

    public SpittleFeedService(SimpMessageSendingOperations message) {
        this.message = message ;
    }

    public void broadcastSpittle(Spittle spittle) {
        String name = spittle.getAuthor().getName() ;
        this.message.convertAndSendToUser(name,"/topic/spittlefeed", spittle);
    }
}
