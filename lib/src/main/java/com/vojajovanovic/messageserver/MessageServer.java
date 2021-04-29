package com.vojajovanovic.messageserver;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

/**
 * Messaging server for Java applications
 */
public class MessageServer extends WebSocketServer {
  /**
   * Dispatcher client ID
   */
  public static String DISPATCHER_ID = "__dispatcher_id";

  /**
   * Request resolver instance
   */
  RequestResolver requestResolver;

  /**
   * Clients stack, indexed by ID
   */
  private HashMap<String, WebSocket> clients = new HashMap<>();

  /**
   * Create server instance
   *
   * @param host ip/host to bind
   * @param port port number to listen
   * @param requestResolver request resolver instance
   */
  public MessageServer(String host, int port, RequestResolver requestResolver) {
    super(new InetSocketAddress(host, port));

    this.requestResolver = requestResolver;
    this.requestResolver.setMessageServer(this);
  }

  /**
   * Handle server-started event
   */
  @Override
  public void onStart() {
    Log.info("Server started.");
  }

  /**
   * Handle client connection-open event
   *
   * @param conn web-socket connection instance
   * @param handshake web-socket handshake instance
   */
  @Override
  public void onOpen(WebSocket conn, ClientHandshake handshake) {
  }

  /**
   * Handle client connection-close event
   *
   * @param conn web-socket connection instance
   * @param code close reason code
   * @param reason close reason additional information
   * @param remote is close initiated by remote
   */
  @Override
  public void onClose(WebSocket conn, int code, String reason, boolean remote) {

  }

  /**
   * Handle error event
   *
   * @param conn web-socket connection instance
   * @param error error exception
   */
  @Override
  public void onError(WebSocket conn, Exception error) {
    Log.error(error);
  }

  /**
   * Handle incoming message event
   *
   * @param conn web-socket connection instance
   * @param message incmoming message string
   */
  @Override
  public void onMessage(WebSocket conn, String message) {
    Message msg = Message.fromJson(message);
    if (msg != null) {
      handleMessage(msg, conn);
    }
  }

  /**
   * Add client to clients stack
   *
   * @param id client ID to add
   * @param client web-socket client
   */
  public void addClient(String id, WebSocket client) {
    clients.put(id, client);
  }

  /**
   * Get client from clients stack
   *
   * @param id clientID to find
   * @return WebSocket
   */
  public WebSocket getClient(String id) {
    return clients.get(id);
  }

  /**
   * Get Dispatcher client from stack
   *
   * @return WebSocket
   */
  public WebSocket getDispatcherClient() {
    return clients.get(DISPATCHER_ID);
  }

  /**
   * Remove client from stack
   *
   * @param id client ID to remove
   */
  public void removeClient(String id) {
    clients.remove(id);
  }

  /**
   * Handle incoming message request
   *
   * @param msg incoming message object
   * @param client web-socket client
   */
  private void handleMessage(Message msg, WebSocket client) {
    MessageHandler op = requestResolver.resolve(msg.subject, client);
    if (op != null) {
      op.handle(msg);
    }
  }
}
