package io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.custom.usuario;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Usuario;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.excecoes.RegraNegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioValidator {

    private final PasswordEncoder passwordEncoder;

    public void validar(String senhaAtual, String novaSenha, Usuario usuarioLogado) {
        if(!validaSenhaAtual(senhaAtual, usuarioLogado.getSenha())) {
            throw new RegraNegocioException("Senha atual incorreta.");
        }
        if(!validaNovaSenha(novaSenha, usuarioLogado.getSenha())) {
            throw new RegraNegocioException("A nova senha não pode ser igual a atual");
        }
    }

    private boolean validaSenhaAtual(String senhaAtual, String senhaAtualCriptografada) {
        return passwordEncoder.matches(senhaAtual, senhaAtualCriptografada);
    }

    private boolean validaNovaSenha(String novaSenha, String senhaAtualCriptografada) {
        return !passwordEncoder.matches(novaSenha, senhaAtualCriptografada);
    }
}
