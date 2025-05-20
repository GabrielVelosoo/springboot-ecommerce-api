package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.carrinho;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteResponseDTO;

import java.math.BigDecimal;
import java.util.List;

public record CarrinhoResponseDTO(
        Long id,
        ClienteResponseDTO cliente,
        List<ItemCarrinhoResponseDTO> itens,
        Boolean finalizado,
        BigDecimal totalCarrinho
    ) {
}
