
package com.karan.aisoftwareagent.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class GeminiService {

    private final ChatClient chatClient;

    public GeminiService(ChatClient.Builder builder) {
        System.out.println(
                "OpenRouter env present: " +
                        (System.getenv("OPENROUTER_API_KEY") != null)
        );

        this.chatClient = builder.build();
    }


    public String askGemini(String prompt) {
        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}
