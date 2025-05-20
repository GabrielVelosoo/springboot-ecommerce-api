package io.github.gabrielvelosoo.ecommerceapi.dominio.service.pedido;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.pedido.Pedido;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.pedido.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    @Override
    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}
