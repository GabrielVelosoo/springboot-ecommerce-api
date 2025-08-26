package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.service;

import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.dto.EmailRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final WebClient webClient;

    @Override
    public Mono<String> enviarEmail(EmailRequestDTO emailRequestDTO) {
        Map<String, Object> body = Map.of(
                "sender", Map.of(
                        "name", emailRequestDTO.fromName(),
                        "email", emailRequestDTO.fromEmail()
                ),
                "to", emailRequestDTO.toEmails().stream()
                        .map(email -> Map.of("email", email))
                        .collect(Collectors.toList()),
                "subject", emailRequestDTO.subject(),
                "htmlContent", emailRequestDTO.htmlContent()
        );

        return webClient.post()
                .uri("/smtp/email")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(e -> System.err.println("Erro ao enviar email: " + e.getMessage()));
    }
}
