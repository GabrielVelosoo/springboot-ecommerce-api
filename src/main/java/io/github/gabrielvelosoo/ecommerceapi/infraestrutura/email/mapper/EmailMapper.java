package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.mapper;

import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.config.EmailProperties;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.dto.BrevoEmailRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.dto.EmailRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailMapper {

    private final EmailProperties emailProperties;

    public BrevoEmailRequestDTO toBrevoRequestWithDefaults(EmailRequestDTO emailRequestDTO) {
        String fromName = emailRequestDTO.fromName() != null ? emailRequestDTO.fromName() : emailProperties.getName();
        String fromEmail = emailRequestDTO.fromEmail() != null ? emailRequestDTO.fromEmail() : emailProperties.getAddress();

        return new BrevoEmailRequestDTO(
                Map.of("name", fromName, "email", fromEmail),
                emailRequestDTO.toEmails().stream()
                        .map(email -> Map.of("email", email))
                        .toList(),
                emailRequestDTO.subject(),
                emailRequestDTO.htmlContent()
        );
    }
}
