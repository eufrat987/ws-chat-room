package com.eufrat.server.handler;

import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;
import java.lang.InterruptedException;
import java.util.ArrayList;
import java.util.List;

public class ChatWebSocketHandler extends TextWebSocketHandler {
  private List<WebSocketSession> sessions = new ArrayList();

  @Override
  public void handleTextMessage(WebSocketSession session, TextMessage message) 
    throws InterruptedException, IOException {
    System.out.println("Received: " + message.getPayload());
    //for (var s: sessions) {
    //  s.sendMessage(message.getPayload());
    //}
  }

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    System.out.println("Client connected");
    sessions.add(session);
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    System.out.println("Connection closed");
  }

  @Override
  public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
    System.out.println("Error:" + exception.getMessage());
  }

}
