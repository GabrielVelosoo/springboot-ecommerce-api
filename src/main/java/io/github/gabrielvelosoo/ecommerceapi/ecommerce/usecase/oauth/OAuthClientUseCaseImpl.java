package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.oauth;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.oauth.OAuthClientRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.oauth.OAuthClientResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.oauth.OAuthClientMapper;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.entity.OAuthClient;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.service.OAuthClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OAuthClientUseCaseImpl implements OAuthClientUseCase {

    private final OAuthClientService oAuthClientService;
    private final OAuthClientMapper oAuthClientMapper;

    @Override
    public OAuthClientResponseDTO salvarClient(OAuthClientRequestDTO oauthClientDTO) {
        OAuthClient oauthClient = oAuthClientMapper.toEntity(oauthClientDTO);
        OAuthClient oAuthClientSalvo = oAuthClientService.salvarClient(oauthClient);
        return oAuthClientMapper.toDTO(oAuthClientSalvo);
    }

    @Override
    public OAuthClientResponseDTO obterPorClientId(String clientId) {
        OAuthClient oauthClient = oAuthClientService.obterPorClientId(clientId);
        return oAuthClientMapper.toDTO(oauthClient);
    }
}
