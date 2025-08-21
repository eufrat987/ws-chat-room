package com.eufrat.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.eufrat.server.handler.ChatWebSocketHandler;

@SpringBootApplication
@EnableWebSocket
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	public WebSocketConfigurer getRawWebSocket() {
		return new WebSocketConfigurer() {

			@Override
			public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
				registry.addHandler(new ChatWebSocketHandler(), "/").setAllowedOriginPatterns("*");
			}
		};
	}
}

