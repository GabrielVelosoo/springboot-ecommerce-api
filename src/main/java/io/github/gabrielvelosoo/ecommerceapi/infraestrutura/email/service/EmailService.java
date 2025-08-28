package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.service;

import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.dto.BrevoEmailRequestDTO;
import reactor.core.publisher.Mono;

public interface EmailService {

    Mono<String> enviarEmail(BrevoEmailRequestDTO brevoEmailRequestDTO);
}
