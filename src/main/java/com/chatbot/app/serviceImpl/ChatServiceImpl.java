package com.chatbot.app.serviceImpl;

import com.chatbot.app.service.ChatService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private WebClient webClient;

    @Override
    public String sendPrompt(String url, Map<String, String> headers, String body) {
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder fullResponse = new StringBuilder();

        Flux<String> responseFlux = webClient.post()
                .uri(url)
                .headers(h -> {
                    if (headers != null) headers.forEach(h::add);
                })
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(body)
                .retrieve()
                .bodyToFlux(String.class);

        boolean[] done = {false};
        responseFlux
                .takeWhile(line -> {
                    try {
                        JsonNode node = mapper.readTree(line);
                        if (node.has("response")) {
                            fullResponse.append(node.get("response").asText());
                        }
                        if (node.has("done") && node.get("done").asBoolean()) {
                            done[0] = true;
                            return false;
                        }
                    } catch (Exception ignored) {
                    }
                    return !done[0];
                })
                .blockLast();

        return fullResponse.toString().replaceAll("\\s+", " ").trim();
    }

}