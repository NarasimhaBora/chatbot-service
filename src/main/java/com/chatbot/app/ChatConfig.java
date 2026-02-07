package com.chatbot.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ChatConfig {

    @Bean
    public WebClient webClient() {
        // ✅ No baseUrl, fully dynamic
        return WebClient.builder().build();
    }
}
