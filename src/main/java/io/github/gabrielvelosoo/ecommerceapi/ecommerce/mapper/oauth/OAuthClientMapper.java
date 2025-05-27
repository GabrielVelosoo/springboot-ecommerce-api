package io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.oauth;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.oauth.OAuthClientRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.oauth.OAuthClientResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.entity.OAuthClient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OAuthClientMapper {

    OAuthClient toEntity(OAuthClientRequestDTO categoriaRequestDTO);
    OAuthClientResponseDTO toDTO(OAuthClient oAuthClient);
}
