package com.tjlcast.websocketpushinfo.package2;

/**
 * Created by tangjialiang on 2018/5/16.
 */

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@ServerEndpoint(value = "/websocket")
@Component
public class WebSocketServerPro{

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    public static String deviceId = new String();
    public static Set<Session> sessions= new HashSet<>();
    public static Map<String,Set<Session>> map = new ConcurrentHashMap<>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        addOnlineCount();           //在线数加1
        log.info("有新连接加入！当前在线人数为" + getOnlineCount());
        try {
            sendMessage(this.hashCode()+"",this.session);
        } catch (IOException e) {
            log.error("websocket.md IO异常");
        }
    }

    public void sendMessage(String message,Session session) throws IOException {
        System.out.println(message);
        session.getBasicRemote().sendText(message);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        //webSocketSet.remove(this);  //从set中删除
        sessions.remove(this.session);
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

        JsonObject jsonObj = (JsonObject)new JsonParser().parse(message);
        String deviceId = jsonObj.get("deviceId").getAsString();
        sessions.add(session);
        map.put(deviceId,sessions);
    }


    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServerPro.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServerPro.onlineCount--;
    }
}