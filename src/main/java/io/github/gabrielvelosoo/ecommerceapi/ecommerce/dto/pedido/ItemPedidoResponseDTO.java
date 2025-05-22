package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoResponseDTO;

public record ItemPedidoResponseDTO(
        Long id,
        Integer quantidade,
        ProdutoResponseDTO produto
    ) {
}
