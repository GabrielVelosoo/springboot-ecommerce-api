package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.usuario;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.usuario.AlterarSenhaDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.usuario.UsuarioResponseDTO;

public interface UsuarioUseCase {

    UsuarioResponseDTO obterUsuarioLogado();
    void alterarSenha(AlterarSenhaDTO senhasDTO);
}
