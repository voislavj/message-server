package com.vojajovanovic.messageserver;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

/**
 * Message object used for communication
 * It has following properties:
 * - from [String]
 * - to [String]
 * - subject [String]
 * - data [JsonElement]
 */
public class Message {
  /**
   * client id message originates from
   */
  public String from;
  /**
   * client it message is being sent to
   */
  public String to;
  /**
   * message subject
   */
  public String subject;
  /**
   * additional message data
   */
  public JsonElement data = new JsonObject();

  /**
   * Create message instance
   */
  public Message() {
  }

  /**
   * Create message instance
   *
   * @param subject message subject
   */
  public Message(String subject) {
    this.subject = subject;
  }

  /**
   * Create message instance
   *
   * @param subject message subject
   * @param data additional message data
   */
  public Message(String subject, JsonElement data) {
    this.subject = subject;
    this.data = data;
  }

  /**
   * Build Message object from JSON string
   *
   * @param json message JSON text representation
   * @return Message
   */
  public static Message fromJson(String json) {
    Message message = null;

    try {
      Gson gson = new Gson();
      message = gson.fromJson(json, Message.class);
    } catch (JsonSyntaxException e) {
      message = null;
    }

    return message;
  }

  /**
   * Convert Message instance to {JsonObject}
   *
   * @return String
   */
  public String asJson() {
    JsonObject json = new JsonObject();

    json.addProperty("from", from);
    json.addProperty("to", to);
    json.addProperty("subject", subject);
    json.add("data", data);

    return json.toString();
  }
}
