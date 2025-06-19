package com.whatsappbot.chatbot.controller;

import com.whatsappbot.chatbot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping
    public Map<String, String> handleChat(@RequestBody Map<String, String> request) {
        String phoneNumber = request.get("phoneNumber");
        String message = request.get("message");

        System.out.println("📨 Received message from " + phoneNumber + ": " + message);

        String reply = chatService.processMessage(message, phoneNumber);

        Map<String, String> response = new HashMap<>();
        response.put("reply", reply);
        return response;
    }
}