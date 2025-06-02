package io.github.gabrielvelosoo.ecommerceapi.dominio.service.usuario;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Role;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Usuario;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.UsuarioRole;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.usuario.UsuarioRepository;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.usuario.UsuarioRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        return usuarioRepository.findByEmail(email);
    }
}
