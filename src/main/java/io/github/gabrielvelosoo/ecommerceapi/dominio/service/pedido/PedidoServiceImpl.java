package io.github.gabrielvelosoo.ecommerceapi.dominio.service.pedido;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.pedido.ItemPedido;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.pedido.Pedido;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.pedido.PedidoRepository;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.excecoes.RegistroNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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

    @Override
    public Pedido obterPedidoPorId(Long pedidoId) {
        return pedidoRepository.findById(pedidoId)
                .orElseThrow( () -> new RegistroNaoEncontradoException("Pedido não encontrado"));
    }

    @Override
    public BigDecimal calcularValorPedido(Pedido pedido) {
        BigDecimal totalPedido = BigDecimal.ZERO;
        for(ItemPedido item : pedido.getItens()) {
            BigDecimal precoUnitario = item.getPrecoUnitario();
            Integer quantidade = item.getQuantidade();
            BigDecimal totalItem = precoUnitario.multiply(BigDecimal.valueOf(quantidade));
            totalPedido = totalPedido.add(totalItem);
        }
        return totalPedido;
    }
}
