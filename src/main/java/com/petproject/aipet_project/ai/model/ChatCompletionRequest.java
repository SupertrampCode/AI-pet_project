package com.petproject.aipet_project.ai.model;

import com.petproject.aipet_project.ai.config.AIConfigs;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatCompletionRequest {

    final String model = AIConfigs.aiModel;

    List<ChatMessage> messages;

    public ChatCompletionRequest(String prompt) {
        this.messages = new ArrayList<>();
        this.messages.add(new ChatMessage("user", prompt));
    }
}
