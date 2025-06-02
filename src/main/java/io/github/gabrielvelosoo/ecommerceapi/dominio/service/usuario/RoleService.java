package io.github.gabrielvelosoo.ecommerceapi.dominio.service.usuario;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Role;

public interface RoleService {

    Role obterRolePorNome(String nome);
}
