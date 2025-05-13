package io.github.gabrielvelosoo.ecommerceapi.dominio.repository.pedido;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.pedido.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
