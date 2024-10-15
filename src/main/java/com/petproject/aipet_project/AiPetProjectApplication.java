package com.petproject.aipet_project;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@PropertySource("classpath:application-secret.properties")
public class AiPetProjectApplication {

    @Value("${openai.api.key}")
    private static String openAIKey;

    public static void main(String[] args) {
        SpringApplication.run(AiPetProjectApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + openAIKey);
            return execution.execute(request, body);
        }));
        return restTemplate;
    }
}
