package io.github.gabrielvelosoo.ecommerceapi.dominio.repository.usuario;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.UsuarioRole;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.UsuarioRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRoleRepository extends JpaRepository<UsuarioRole, UsuarioRoleId> {
}
