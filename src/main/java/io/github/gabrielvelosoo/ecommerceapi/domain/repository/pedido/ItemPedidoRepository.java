package io.github.gabrielvelosoo.ecommerceapi.domain.repository.pedido;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.pedido.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
