package io.github.gabrielvelosoo.ecommerceapi.dominio.service.pedido;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.pedido.ItemPedido;
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
        if(pedido.getItens() != null) {
            for(ItemPedido item : pedido.getItens()) {
                item.setPedido(pedido);
            }
        }
        return pedidoRepository.save(pedido);
    }
}
