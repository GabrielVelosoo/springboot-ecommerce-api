package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.service;

import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.dto.EmailRequestDTO;
import reactor.core.publisher.Mono;

public interface EmailService {

    Mono<String> enviarEmail(EmailRequestDTO emailRequestDTO);
}
