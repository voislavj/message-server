package com.vojajovanovic.messageserver;

import org.java_websocket.WebSocket;

public abstract class RequestResolver {
  private MessageServer server;

  public void setMessageServer(MessageServer server) {
    this.server = server;
  }

  public MessageServer getMessageServer() {
    return server;
  }

  abstract public MessageHandler resolve(String subject, WebSocket client);
}