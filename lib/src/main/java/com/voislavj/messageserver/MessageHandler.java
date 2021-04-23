package com.voislavj.messageserver;

import org.java_websocket.WebSocket;

abstract public class MessageHandler {
  protected MessageServer server;
  protected WebSocket client;

  public MessageHandler(MessageServer server, WebSocket client) {
    this.server = server;
    this.client = client;
  }

  public abstract void handle(Message message);
}
