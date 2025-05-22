package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.carrinho;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteResponseDTO;

import java.math.BigDecimal;
import java.util.List;

public record CarrinhoResponseDTO(
        Long id,
        Boolean finalizado,
        BigDecimal totalCarrinho,
        ClienteResponseDTO cliente,
        List<ItemCarrinhoResponseDTO> itens
    ) {
}
