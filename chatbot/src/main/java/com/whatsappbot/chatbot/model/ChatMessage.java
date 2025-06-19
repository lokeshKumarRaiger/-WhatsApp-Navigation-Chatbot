package com.whatsappbot.chatbot.model;
import java.time.Instant;
public class ChatMessage {
    private String phoneNumber;
    private String userMessage;
    private String botReply;
    private Instant timestamp;

    public ChatMessage() {}

    public ChatMessage(String phoneNumber, String userMessage, String botReply) {
        this.phoneNumber = phoneNumber;
        this.userMessage = userMessage;
        this.botReply = botReply;
        this.timestamp = Instant.now();
    }

    // Getters & setters
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getBotReply() {
        return botReply;
    }

    public void setBotReply(String botReply) {
        this.botReply = botReply;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
