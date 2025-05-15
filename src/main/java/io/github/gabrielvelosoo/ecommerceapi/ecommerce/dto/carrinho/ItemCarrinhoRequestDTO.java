package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.carrinho;

public record ItemCarrinhoRequestDTO(
        Long produtoId,
        Integer quantidade
    ) {
}
