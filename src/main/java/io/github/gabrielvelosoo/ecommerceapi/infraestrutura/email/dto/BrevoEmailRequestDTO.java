package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.dto;

import java.util.List;
import java.util.Map;

public record BrevoEmailRequestDTO(
        Map<String, String> sender,
        List<Map<String, String>> to,
        String subject,
        String htmlContent
    ) {
}
