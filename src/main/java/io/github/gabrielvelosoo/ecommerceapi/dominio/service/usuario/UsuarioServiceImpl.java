package io.github.gabrielvelosoo.ecommerceapi.dominio.service.usuario;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Role;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Usuario;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.UsuarioRole;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.usuario.UsuarioRepository;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.usuario.UsuarioRoleRepository;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.excecoes.RegistroNaoEncontradoException;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.auth.CustomAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@SuppressWarnings("ALL")
@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioRoleRepository usuarioRoleRepository;

    @Override
    public void adicionarRoleUser(Usuario usuario, Role role) {
        usuarioRoleRepository.save(new UsuarioRole(usuario, role));
    }

    @Override
    public Usuario obterUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow( () -> new RegistroNaoEncontradoException("Usuário com este e-mail não encontrado"));
    }

    @Override
    public Usuario obterUsuarioLogado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication instanceof CustomAuthentication auth) {
            return auth.usuario();
        }
        return null;
    }
}
