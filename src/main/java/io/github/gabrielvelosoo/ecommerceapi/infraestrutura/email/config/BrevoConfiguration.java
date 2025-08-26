package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BrevoConfiguration {

    @Value("${brevo.api.key}")
    private String apiKey;

    @Bean
    public WebClient brevoWebClient() {
        return WebClient.builder()
                .baseUrl("https://api.brevo.com/v3")
                .defaultHeader("api-key", apiKey)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }
}
