package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.oauth;

public record OAuthClientResponseDTO(
        Long id,
        String clientId,
        String clientSecret,
        String redirectUri,
        String scope
    ) {
}
