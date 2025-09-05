package io.github.gabrielvelosoo.ecommerceapi.dominio.repository.cliente;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByEmail(String email);
    Optional<Cliente> findByKeycloakUsuarioId(String keycloakUsuarioId);
}
