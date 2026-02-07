package com.chatbot.app.service;

import reactor.core.publisher.Mono;
import java.util.Map;

public interface ChatService {
    String sendPrompt(String url, Map<String, String> headers, String body);
}
