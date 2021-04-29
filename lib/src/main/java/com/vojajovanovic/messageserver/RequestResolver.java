package com.vojajovanovic.messageserver;

import org.java_websocket.WebSocket;

/**
 * Resolves incoming Message object,
 * and delegates it to a MessageHandler object
 */
public abstract class RequestResolver {
  /**
   * MessageServer instance
   */
  private MessageServer server;

  /**
   * Store instance of the server
   *
   * @param server MessageServer instance 
   */
  public void setMessageServer(MessageServer server) {
    this.server = server;
  }

  /**
   * Get server instance
   *
   * @return MessageServer server instance
   */
  public MessageServer getMessageServer() {
    return server;
  }

  /**
   * Resolve incoming message to MessageHandler instance
   *
   * @param subject message subject
   * @param client socket client
   * @return MessageHandler
   */
  abstract public MessageHandler resolve(String subject, WebSocket client);
}