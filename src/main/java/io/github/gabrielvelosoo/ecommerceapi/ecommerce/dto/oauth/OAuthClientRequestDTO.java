package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.oauth;

public record OAuthClientRequestDTO(
        String clientId,
        String clientSecret,
        String redirectUri,
        String postLogoutRedirectUri,
        String scope
    ) {
}
