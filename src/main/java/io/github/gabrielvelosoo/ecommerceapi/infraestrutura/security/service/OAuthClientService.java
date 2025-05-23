package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.service;

import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.entity.OAuthClient;

public interface OAuthClientService {

    OAuthClient salvarClient(OAuthClient oauthClient);
}
