package com.websocket.control;

import com.websocket.websocket.WebSocketHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by user on 2017/5/24.
 */
@Controller
@RequestMapping("/websocket")
public class WebSocketTest {

    @Resource
    WebSocketHandler handler;

    @RequestMapping("/broadcast")
    public void broadcast(@RequestParam("msg") String message) {
        handler.broadcast("这条通知事由websocket发送的："+message);
    }
}
