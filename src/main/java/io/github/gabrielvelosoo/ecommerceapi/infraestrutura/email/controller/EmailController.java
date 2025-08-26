package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.controller;

import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.dto.EmailRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/emails")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping(value = "/enviar")
    public Mono<String> enviarEmail(@RequestBody EmailRequestDTO emailRequestDTO) {
        return emailService.enviarEmail(emailRequestDTO);
    }
}
