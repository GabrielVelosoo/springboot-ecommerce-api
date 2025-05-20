package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.pedido;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.carrinho.Carrinho;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.pedido.Pedido;
import io.github.gabrielvelosoo.ecommerceapi.dominio.service.carrinho.CarrinhoService;
import io.github.gabrielvelosoo.ecommerceapi.dominio.service.pedido.PedidoService;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido.PedidoCarrinhoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido.PedidoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido.PedidoResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.pedido.PedidoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidoUseCaseImpl implements PedidoUseCase {

    private final PedidoService pedidoService;
    private final PedidoMapper pedidoMapper;
    private final CarrinhoService carrinhoService;

    @Override
    public PedidoResponseDTO criarPedido(PedidoRequestDTO pedidoDTO) {
        Pedido pedido = pedidoMapper.toEntity(pedidoDTO);
        Pedido pedidoSalvo = pedidoService.criarPedido(pedido);
        return pedidoMapper.toDTO(pedidoSalvo);
    }

    @Override
    public PedidoResponseDTO criarPedidoComCarrinho(PedidoCarrinhoRequestDTO pedidoCarrinhoDTO) {
        Carrinho carrinho = carrinhoService.obterCarrinhoPorId(pedidoCarrinhoDTO.carrinhoId());
        Pedido pedido = pedidoMapper.toPedidoFromCarrinho(carrinho, pedidoCarrinhoDTO.formaPagamento(), pedidoCarrinhoDTO.enderecoEntrega());
        pedidoService.criarPedido(pedido);
        return pedidoMapper.toDTO(pedido);
    }
}
