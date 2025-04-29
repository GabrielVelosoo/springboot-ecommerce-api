package io.github.gabrielvelosoo.ecommerceapi.domain.repository.cliente;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
