package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente;

import java.time.LocalDateTime;

public record ClienteResponseDTO(
        Long id,
        String email,
        String senha,
        String nome,
        String sobrenome,
        String cpf,
        String cep,
        LocalDateTime dataNascimento
    ) {
}
