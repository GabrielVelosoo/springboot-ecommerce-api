package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto;

import java.time.LocalDateTime;

public record CategoriaResponseDTO(
        Long id,
        String nome,
        LocalDateTime dataCadastro,
        LocalDateTime dataAtualizacao
    ) {
}
