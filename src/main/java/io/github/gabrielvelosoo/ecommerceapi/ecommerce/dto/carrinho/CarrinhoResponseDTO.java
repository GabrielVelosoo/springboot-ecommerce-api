package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.carrinho;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteResponseDTO;

import java.math.BigDecimal;

public record CarrinhoResponseDTO(
        Long id,
        ClienteResponseDTO cliente,
        Boolean finalizado,
        BigDecimal totalCarrinho
    ) {
}
