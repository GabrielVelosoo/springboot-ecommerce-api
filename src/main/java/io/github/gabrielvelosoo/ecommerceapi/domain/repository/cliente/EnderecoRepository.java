package io.github.gabrielvelosoo.ecommerceapi.domain.repository.cliente;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.cliente.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> findByClienteId(Long clienteId);
}
