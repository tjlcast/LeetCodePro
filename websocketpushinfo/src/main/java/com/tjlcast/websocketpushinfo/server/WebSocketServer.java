package com.tjlcast.websocketpushinfo.server;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by tangjialiang on 2018/5/16.
 */
@Slf4j
@ServerEndpoint(value = "/websocket")
@Component
public class WebSocketServer {
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    @Setter
    @Getter
    private static int onlineCount = 0 ;

    // 存放每个客户端的WebSocket对象
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>() ;

    // 与某个客户端的连接会话，通过会话向客户端发送数据
    private Session session ;

    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session) {
        this.session = session ;
        WebSocketServer.webSocketSet.add(this) ;    // 加入set中
        addOnlineCount();           // 在线人数加1
        log.info("有新连接加入！当前在线人数为" + getOnlineCount());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("来自客户端的消息:" + message);

        //群发消息
        for (WebSocketServer item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    private void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 群发自定义消息(向所有的socket连接发送消息)
     * */
    public static void sendInfo(String message) throws IOException {
        log.info(message);
        for (WebSocketServer item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                continue;
            }
        }
    }

    private static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    private static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}