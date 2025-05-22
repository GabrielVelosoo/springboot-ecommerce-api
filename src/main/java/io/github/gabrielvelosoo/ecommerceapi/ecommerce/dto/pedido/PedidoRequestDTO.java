package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.pedido.FormaPagamento;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.EnderecoRequestDTO;

import java.util.List;

public record PedidoRequestDTO(
        Long clienteId,
        List<ItemPedidoRequestDTO> itens,
        FormaPagamento formaPagamento,
        EnderecoRequestDTO enderecoEntrega
    ) {
}
