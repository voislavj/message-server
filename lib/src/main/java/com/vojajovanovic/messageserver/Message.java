package com.vojajovanovic.messageserver;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

public class Message {
  public String from;
  public String to;
  public String subject;
  public JsonElement data = new JsonObject();

  public Message() {
  }

  public Message(String subject) {
    this.subject = subject;
  }

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

  public Message(String subject, JsonElement data) {
    this.subject = subject;
    this.data = data;
  }

  public String asJson() {
    JsonObject json = new JsonObject();

    json.addProperty("from", from);
    json.addProperty("to", to);
    json.addProperty("subject", subject);
    json.add("data", data);

    return json.toString();
  }
}
