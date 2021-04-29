package com.vojajovanovic.messageserver;

import org.java_websocket.WebSocket;

/**
 * Message handler class
 */
abstract public class MessageHandler {
  /**
   * server instance
   */
  protected MessageServer server;
  /**
   * web-socket client instance
   */
  protected WebSocket client;

  /**
   * Create message handler instance
   *
   * @param server server instance
   * @param client web-socket client
   */
  public MessageHandler(MessageServer server, WebSocket client) {
    this.server = server;
    this.client = client;
  }

  /**
   * Handle incoming message
   *
   * @param message incoming message object
   */
  public abstract void handle(Message message);
}
