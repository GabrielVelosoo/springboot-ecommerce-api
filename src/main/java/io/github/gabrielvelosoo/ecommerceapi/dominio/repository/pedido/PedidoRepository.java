package io.github.gabrielvelosoo.ecommerceapi.dominio.repository.pedido;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
