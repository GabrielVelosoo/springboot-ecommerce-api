package io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.usuario;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Usuario;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.usuario.UsuarioResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioResponseDTO toDTO(Usuario usuario);
}
