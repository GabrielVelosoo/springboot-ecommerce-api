package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente;

public record ClienteResponseDTO(
        Long id,
        String nome,
        String cpf,
        String telefone
    ) {
}
