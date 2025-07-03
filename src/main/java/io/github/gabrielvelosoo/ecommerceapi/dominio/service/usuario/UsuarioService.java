package io.github.gabrielvelosoo.ecommerceapi.dominio.service.usuario;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Role;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Usuario;

public interface UsuarioService {

    void adicionarRoleUser(Usuario usuario, Role role);
    Usuario obterUsuarioPorEmail(String email);
    Usuario obterUsuarioLogado();
}
