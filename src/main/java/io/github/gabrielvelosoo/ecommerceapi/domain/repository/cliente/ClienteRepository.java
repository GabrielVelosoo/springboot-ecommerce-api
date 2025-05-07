package io.github.gabrielvelosoo.ecommerceapi.domain.repository.cliente;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCpf(String cpf);
}
