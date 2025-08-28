package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.service;

import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.dto.BrevoEmailRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final WebClient webClient;

    @Override
    public Mono<String> enviarEmail(BrevoEmailRequestDTO brevoEmailRequestDTO) {
        return webClient.post()
                .uri("/smtp/email")
                .bodyValue(brevoEmailRequestDTO)
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(e -> System.err.println("Erro ao enviar email: " + e.getMessage()));
    }
}
