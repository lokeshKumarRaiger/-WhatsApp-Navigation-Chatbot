package com.whatsappbot.chatbot.service;


import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.whatsappbot.chatbot.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ChatService {

    @Autowired
    private WhatsappService whatsappService;

    public String processMessage(String message, String phoneNumber) {
        String reply;

        switch (message.toLowerCase()) {
            case "hi", "hello" -> reply = "Hi there! How can I help you with navigation today?";
            case "help" -> reply = "You can ask things like: 'route to Hyderabad' or 'how to reach airport'";
            case "bye" -> reply = "Goodbye! Safe travels.";
            default -> reply = "Sorry, I didn’t understand that. Type 'help' for options.";
        }

        saveToFirestore(phoneNumber, message, reply);
        whatsappService.sendWhatsAppMessage(phoneNumber, reply);

        return reply;
    }

    private void saveToFirestore(String phoneNumber, String message, String reply) {
        try {
            Firestore db = FirestoreClient.getFirestore();
            Map<String, Object> chat = new HashMap<>();
            chat.put("phoneNumber", phoneNumber);
            chat.put("userMessage", message);
            chat.put("botReply", reply);
            chat.put("timestamp", new Date());

            db.collection("chat-history").add(chat);
            System.out.println("📥 Saved to Firestore: " + message + " → " + reply);
        } catch (Exception e) {
            System.out.println("❌ Firestore saving failed:");
            e.printStackTrace();
        }
    }
}