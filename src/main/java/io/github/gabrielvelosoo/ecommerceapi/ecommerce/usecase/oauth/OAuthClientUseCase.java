package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.oauth;

import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.entity.OAuthClient;

public interface OAuthClientUseCase {

    OAuthClient salvarClient(OAuthClient oauthClient);
    OAuthClient obterPorClientId(String clientId);
}
