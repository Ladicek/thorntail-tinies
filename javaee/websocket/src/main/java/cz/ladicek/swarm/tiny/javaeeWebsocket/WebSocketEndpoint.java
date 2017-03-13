package cz.ladicek.swarm.tiny.javaeeWebsocket;

import javax.annotation.PostConstruct;
import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/echo")
public class WebSocketEndpoint {
    @PostConstruct
    public void init() {
        System.out.println("WebSocket endpoint initialized");
    }

    @OnMessage
    public String onMessage(String message) throws IOException {
        return "ECHO: " + message;
    }
}
