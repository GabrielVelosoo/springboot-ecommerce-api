package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.service;

import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.dto.BrevoEmailRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.dto.EmailRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.mapper.EmailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final WebClient webClient;
    private final EmailMapper emailMapper;

    @Override
    public Mono<String> enviarEmail(EmailRequestDTO emailRequestDTO) {
        BrevoEmailRequestDTO body = emailMapper.toBrevoRequest(emailRequestDTO);
        return webClient.post()
                .uri("/smtp/email")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(e -> System.err.println("Erro ao enviar email: " + e.getMessage()));
    }
}
