package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido;

public record ItemPedidoRequestDTO(
        Long produtoId,
        Integer quantidade
    ) {
}
