package com.whatsappbot.chatbot.service;

import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;

@Service
public class WhatsappService {

    @Value("${twilio.whatsapp-from}")
    private String fromNumber;

    public void sendWhatsAppMessage(String toNumber, String messageBody) {
        Message message = Message.creator(
                new PhoneNumber("whatsapp:" + toNumber),
                new PhoneNumber(fromNumber),
                messageBody
        ).create();

        System.out.println("✅ Twilio WhatsApp sent: SID=" + message.getSid());
    }
}