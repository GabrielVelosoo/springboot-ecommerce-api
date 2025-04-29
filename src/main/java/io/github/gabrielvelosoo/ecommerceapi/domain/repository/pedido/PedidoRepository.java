package io.github.gabrielvelosoo.ecommerceapi.domain.repository.pedido;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
