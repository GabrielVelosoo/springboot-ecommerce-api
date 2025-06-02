package io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_usuario_role")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class UsuarioRole implements Serializable {

    @EmbeddedId
    private UsuarioRoleId id = new UsuarioRoleId();

    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    @JsonIgnore
    private Role role;

    @CreatedDate
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @LastModifiedDate
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    public UsuarioRole() {}

    public UsuarioRole(Usuario usuario, Role role) {
        this.usuario = usuario;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioRole that = (UsuarioRole) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
