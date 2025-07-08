package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRequestDTO(
        @NotBlank(message = "Categoria é obrigatório")
        String nome,
        Long categoriaPaiId
    ) {
}
