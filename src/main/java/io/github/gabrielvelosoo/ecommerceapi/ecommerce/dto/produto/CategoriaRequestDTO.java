package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoriaRequestDTO(
        @NotBlank(message = "Categoria é obrigatório")
        @Size(min = 2, max = 50, message = "Categoria deve ter entre 2 e 50 caracteres")
        String nome
    ) {
}
