package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.usuario.UsuarioRoleResponseDTO;

import java.time.LocalDateTime;
import java.util.Set;

public record ClienteResponseDTO(
        Long id,
        String email,
        String senha,
        String nome,
        String sobrenome,
        String cpf,
        String telefone,
        LocalDateTime dataNascimento,
        Set<UsuarioRoleResponseDTO> usuarioRoles
    ) {
}
