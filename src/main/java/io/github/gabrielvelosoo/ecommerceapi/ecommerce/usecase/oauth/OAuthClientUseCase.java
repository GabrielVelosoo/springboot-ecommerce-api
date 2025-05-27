package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.oauth;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.oauth.OAuthClientRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.oauth.OAuthClientResponseDTO;

public interface OAuthClientUseCase {

    OAuthClientResponseDTO salvarClient(OAuthClientRequestDTO oauthClientDTO);
    OAuthClientResponseDTO obterPorClientId(String clientId);
}
