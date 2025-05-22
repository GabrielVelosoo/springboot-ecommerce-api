package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.pedido.FormaPagamento;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.pedido.StatusPedido;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.EnderecoResponseDTO;

import java.math.BigDecimal;
import java.util.List;

public record PedidoResponseDTO(
        Long id,
        BigDecimal frete,
        BigDecimal totalPedido,
        FormaPagamento formaPagamento,
        StatusPedido status,
        ClienteResponseDTO cliente,
        List<ItemPedidoResponseDTO> itens,
        EnderecoResponseDTO enderecoEntrega
    ) {
}
