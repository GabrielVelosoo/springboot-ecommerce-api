package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.oauth;

import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.entity.OAuthClient;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.service.OAuthClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OAuthClientUseCaseImpl implements OAuthClientUseCase {

    private final OAuthClientService oAuthClientService;

    @Override
    public OAuthClient salvarClient(OAuthClient oauthClient) {
        return oAuthClientService.salvarClient(oauthClient);
    }

    @Override
    public OAuthClient obterPorClientId(String clientId) {
        return oAuthClientService.obterPorClientId(clientId);
    }
}
