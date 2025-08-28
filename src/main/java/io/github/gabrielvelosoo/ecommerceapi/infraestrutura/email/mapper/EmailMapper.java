package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.mapper;

import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.dto.BrevoEmailRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.dto.EmailRequestDTO;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EmailMapper {

    public BrevoEmailRequestDTO toBrevoRequest(EmailRequestDTO emailRequestDTO) {
        return new BrevoEmailRequestDTO(
                Map.of("name", emailRequestDTO.fromName(), "email", emailRequestDTO.fromEmail()),
                emailRequestDTO.toEmails().stream()
                        .map(email -> Map.of("email", email))
                        .toList(),
                emailRequestDTO.subject(),
                emailRequestDTO.htmlContent()
        );
    }
}
