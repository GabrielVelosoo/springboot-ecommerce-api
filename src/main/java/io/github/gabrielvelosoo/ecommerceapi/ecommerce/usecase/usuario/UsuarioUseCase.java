package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.usuario;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.usuario.AlterarSenhaDTO;

public interface UsuarioUseCase {

    void alterarSenha(AlterarSenhaDTO senhasDTO);
}
