package io.github.gabrielvelosoo.ecommerceapi.dominio.repository.usuario;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
}
