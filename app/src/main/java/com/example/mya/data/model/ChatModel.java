package com.example.mya.data.model;

public class ChatModel {
    private  String message;
    private String senderID;
    public ChatModel(){}

    public ChatModel(String message, String senderID) {
        this.message = message;
        this.senderID = senderID;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }
}
