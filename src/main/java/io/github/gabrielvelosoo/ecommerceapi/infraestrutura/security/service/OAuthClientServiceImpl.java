package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.service;

import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.excecoes.RegistroNaoEncontradoException;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.entity.OAuthClient;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.repository.OAuthClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuthClientServiceImpl implements OAuthClientService {

    private final OAuthClientRepository oAuthClientRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public OAuthClient salvarClient(OAuthClient oauthClient) {
        String secretCriptografada = passwordEncoder.encode(oauthClient.getClientSecret());
        oauthClient.setClientSecret(secretCriptografada);
        return oAuthClientRepository.save(oauthClient);
    }

    @Override
    public OAuthClient obterPorClientId(String clientId) {
        return oAuthClientRepository.findByClientId(clientId)
                .orElseThrow( () -> new RegistroNaoEncontradoException("Client não encontrado"));
    }
}
