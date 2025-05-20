package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoResponseDTO;

import java.math.BigDecimal;

public record ItemPedidoResponseDTO(
        Long id,
        ProdutoResponseDTO produto,
        Integer quantidade,
        BigDecimal precoUnitario
    ) {
}
