package io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
public class UsuarioRoleId implements Serializable {

    @Column(name = "usuario_id", updatable = false)
    private Long usuarioId;

    @Column(name = "role_id", updatable = false)
    private Long roleId;

    public UsuarioRoleId() {}

    public UsuarioRoleId(Long usuarioId, Long roleId) {
        this.usuarioId = usuarioId;
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioRoleId that = (UsuarioRoleId) o;
        return Objects.equals(usuarioId, that.usuarioId) && Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, roleId);
    }
}
