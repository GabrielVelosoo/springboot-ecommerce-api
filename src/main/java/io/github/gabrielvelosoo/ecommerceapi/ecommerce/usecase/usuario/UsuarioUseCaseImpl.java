package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.usuario;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Usuario;
import io.github.gabrielvelosoo.ecommerceapi.dominio.service.usuario.UsuarioService;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.usuario.AlterarSenhaDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.custom.usuario.UsuarioValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioUseCaseImpl implements UsuarioUseCase {

    private final UsuarioService usuarioService;
    private final UsuarioValidator usuarioValidator;

    @Override
    public void alterarSenha(AlterarSenhaDTO senhasDTO) {
        Usuario usuarioLogado = usuarioService.obterUsuarioLogado();
        usuarioValidator.validar(senhasDTO.senhaAtual(), senhasDTO.novaSenha(), usuarioLogado);
        usuarioService.alterarSenha(senhasDTO.novaSenha(), usuarioLogado);
    }
}
