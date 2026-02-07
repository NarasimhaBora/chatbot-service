package com.chatbot.app.controller;

import com.chatbot.app.ChatbotProperties;
import com.chatbot.app.service.ChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;
    private final ChatbotProperties chatbotProperties;

    public ChatController(ChatService chatService, ChatbotProperties chatbotProperties) {
        this.chatService = chatService;
        this.chatbotProperties = chatbotProperties;
    }


    @PostMapping
    public String chat(@RequestBody Map<String, String> payload) {
        String body = buildRequestBody(payload);
        String response = chatService.sendPrompt(
                chatbotProperties.getUrl(),
                chatbotProperties.getHeaders(),
                body
        );
        System.out.println("Chat response: " + response);
        return response;
    }

    @GetMapping
    public String chatGet() {
        return "Please use POST method for /chat endpoint.";
    }


    private String buildRequestBody(Map<String, String> payload) {
        String prompt = payload.get("prompt");
        return "{\"model\":\"codellama\",\"prompt\":\"" + prompt + "\"}";
    }
}