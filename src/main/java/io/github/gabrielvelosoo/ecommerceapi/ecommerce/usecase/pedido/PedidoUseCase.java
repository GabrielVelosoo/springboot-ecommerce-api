package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.pedido;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido.PedidoCarrinhoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido.PedidoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido.PedidoResponseDTO;

public interface PedidoUseCase {

    PedidoResponseDTO criarPedido(PedidoRequestDTO pedidoDTO);
    PedidoResponseDTO criarPedidoComCarrinho(PedidoCarrinhoRequestDTO pedidoCarrinhoDTO);
}
