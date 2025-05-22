package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.carrinho;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoResponseDTO;

import java.math.BigDecimal;

public record ItemCarrinhoResponseDTO(
        Long id,
        Integer quantidade,
        BigDecimal precoUnitario,
        ProdutoResponseDTO produto
    ) {
}
