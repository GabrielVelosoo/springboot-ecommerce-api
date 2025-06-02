package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.auth;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Usuario;
import io.github.gabrielvelosoo.ecommerceapi.dominio.service.usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String senhaDigitada = authentication.getCredentials().toString();
        Usuario usuarioEncontrado = usuarioService.obterUsuarioPorEmail(email);
        if(usuarioEncontrado == null) {
            throw getUserNotFoundError();
        }
        String senhaCriptografada = usuarioEncontrado.getSenha();
        boolean senhaChecada = checarSenha(senhaDigitada, senhaCriptografada);
        if(senhaChecada) {
            return new CustomAuthentication(usuarioEncontrado);
        }
        throw getUserNotFoundError();
    }

    private UsernameNotFoundException getUserNotFoundError() {
        return new UsernameNotFoundException("E-mail e/ou senha incorretos");
    }

    private boolean checarSenha(String senhaDigitada, String senhaCriptografada) {
        return passwordEncoder.matches(senhaDigitada, senhaCriptografada);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
