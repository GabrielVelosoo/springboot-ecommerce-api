package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.usuario;

import jakarta.validation.constraints.NotBlank;

public record AlterarSenhaDTO(
        @NotBlank(message = "Campo obrigatório")
        String senhaAtual,
        @NotBlank(message = "Campo obrigatório")
        String novaSenha
    ) {
}
