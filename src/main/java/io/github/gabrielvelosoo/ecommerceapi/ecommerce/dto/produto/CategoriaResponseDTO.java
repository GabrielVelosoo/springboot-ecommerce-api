package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto;

import java.util.List;

public record CategoriaResponseDTO(
        Long id,
        String nome,
        String slug,
        List<CategoriaResponseDTO> subcategorias
    ) {
}
