package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.repository;

import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.excecoes.RegistroNaoEncontradoException;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.entity.OAuthClient;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomClientRegistrationRepository implements ClientRegistrationRepository {

    private final OAuthClientRepository oAuthClientRepository;

    @Override
    public ClientRegistration findByRegistrationId(String registrationId) {
        OAuthClient oAuthClient = oAuthClientRepository.findByClientId("meu-secret")
                .orElseThrow( () -> new RegistroNaoEncontradoException("Client não encontrado no OAuthClientRepository"));

        return ClientRegistration
                .withRegistrationId(oAuthClient.getClientId())
                .clientId(oAuthClient.getClientId())
                .clientAuthenticationMethod(ClientAuthenticationMethod.NONE)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri(oAuthClient.getRedirectUri())
                .scope(oAuthClient.getScope())
                .authorizationUri("http://localhost:8080/oauth2/authorize")
                .tokenUri("http://localhost:8080/oauth2/token")
                .jwkSetUri("http://localhost:8080/oauth2/jwks")
                .issuerUri("http://localhost:8080")
                .build();
    }
}
