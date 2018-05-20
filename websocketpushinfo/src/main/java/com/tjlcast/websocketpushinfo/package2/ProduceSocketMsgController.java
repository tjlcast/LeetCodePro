package com.tjlcast.websocketpushinfo.package2;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tangjialiang on 2018/5/16.
 */
@RestController
public class ProduceSocketMsgController {

    @RequestMapping(value = "/pushVideoListToWeb", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Map<String, Object> pushVideoListToWeb(@RequestBody Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>();

        try {
            WebSocketServer.sendInfo("有新客户呼入, sltAccountId:" + param.get("sltAccountId"));
            result.put("operationResult", true) ;
        } catch (Exception e) {
            result.put("operationResult", true) ;
        }

        return result ;
    }
}
