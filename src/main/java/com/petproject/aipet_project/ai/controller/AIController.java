package com.petproject.aipet_project.ai.controller;

import com.petproject.aipet_project.ai.config.AIConfigs;
import com.petproject.aipet_project.ai.model.ChatCompletionRequest;
import com.petproject.aipet_project.ai.model.ChatCompletionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AIController {

    @Autowired
    private final RestTemplate restTemplate;

    public AIController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/my-ai-response")
    public String getOpenAIResponse(@RequestBody String prompt){
        ChatCompletionRequest chatCompletionRequest = new ChatCompletionRequest(prompt);
        ChatCompletionResponse response = restTemplate
                .postForObject(AIConfigs.url,
                        chatCompletionRequest,
                        ChatCompletionResponse.class);
        return response.getChoices().get(0).getMessage().getContent();
    }
}
