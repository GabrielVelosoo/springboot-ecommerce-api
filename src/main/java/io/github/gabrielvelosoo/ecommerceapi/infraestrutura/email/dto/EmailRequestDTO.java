package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.dto;

import java.util.List;

public record EmailRequestDTO(
        String fromName,
        String fromEmail,
        List<String> toEmails,
        String subject,
        String htmlContent
    ) {
}
