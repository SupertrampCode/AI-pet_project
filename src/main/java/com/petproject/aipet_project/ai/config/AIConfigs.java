package com.petproject.aipet_project.ai.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AIConfigs {

    @Value("${spring.ai.openai.chat.options.model}")
    public static String aiModel;

    @Value("${spring.ai.openai.address}")
    public static String url;

    @Value(value = "{spring.ai.openai.chat.options.max-tokens}")
    public static int max_tokens;
}
