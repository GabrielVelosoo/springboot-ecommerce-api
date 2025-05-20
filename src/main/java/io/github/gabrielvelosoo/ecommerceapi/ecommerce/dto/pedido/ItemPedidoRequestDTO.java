package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido;

import java.math.BigDecimal;

public record ItemPedidoRequestDTO(
        Long produtoId,
        Integer quantidade,
        BigDecimal precoUnitario
    ) {
}
