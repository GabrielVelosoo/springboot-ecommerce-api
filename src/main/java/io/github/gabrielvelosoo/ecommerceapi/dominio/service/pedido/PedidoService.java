package io.github.gabrielvelosoo.ecommerceapi.dominio.service.pedido;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.pedido.Pedido;

import java.math.BigDecimal;

public interface PedidoService {

    Pedido criarPedido(Pedido pedido);
    Pedido obterPedidoPorId(Long pedidoId);
    BigDecimal calcularValorPedido(Pedido pedido);
}
