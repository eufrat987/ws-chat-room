package com.eufrat.server.handler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;
import java.lang.InterruptedException;

public class ChatWebSocketHandler extends TextWebSocketHandler {

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) 
		throws InterruptedException, IOException {
		System.out.println("hello all");
		System.out.println(message.getPayload());
	}

	//@Override
	//public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	//}
}
