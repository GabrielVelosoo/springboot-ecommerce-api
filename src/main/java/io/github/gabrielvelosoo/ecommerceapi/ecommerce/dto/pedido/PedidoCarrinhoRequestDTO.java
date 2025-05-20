package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.pedido.FormaPagamento;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.EnderecoRequestDTO;

public record PedidoCarrinhoRequestDTO(
        Long carrinhoId,
        FormaPagamento formaPagamento,
        EnderecoRequestDTO enderecoEntrega
    ) {
}
