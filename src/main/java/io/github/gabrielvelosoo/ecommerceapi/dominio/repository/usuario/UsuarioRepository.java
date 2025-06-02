package io.github.gabrielvelosoo.ecommerceapi.dominio.repository.usuario;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
}
