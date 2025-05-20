package io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.pedido;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.carrinho.Carrinho;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.carrinho.ItemCarrinho;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.cliente.Endereco;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.pedido.FormaPagamento;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.pedido.ItemPedido;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.pedido.Pedido;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.pedido.StatusPedido;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.cliente.ClienteRepository;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.produto.ProdutoRepository;
import io.github.gabrielvelosoo.ecommerceapi.dominio.service.carrinho.CarrinhoService;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.EnderecoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido.ItemPedidoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido.PedidoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido.PedidoResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.cliente.ClienteMapper;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.cliente.EnderecoMapper;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.produto.ProdutoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class, ProdutoMapper.class, EnderecoMapper.class, ItemPedidoMapper.class})
public abstract class PedidoMapper {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CarrinhoService carrinhoService;

    @Autowired
    private EnderecoMapper enderecoMapper;

    @Mapping(target = "cliente", expression = "java( clienteRepository.findById(pedidoDTO.clienteId()).orElse(null) )")
    @Mapping(target = "itens", expression = "java( mapItensPedido(pedidoDTO.itens()) )")
    public abstract Pedido toEntity(PedidoRequestDTO pedidoDTO);

    protected List<ItemPedido> mapItensPedido(List<ItemPedidoRequestDTO> itensPedidoDTO) {
        if(itensPedidoDTO == null) return null;
        return itensPedidoDTO.stream()
                .map(itensDTO -> {
                    ItemPedido item = new ItemPedido();
                    item.setProduto(produtoRepository.findById(itensDTO.produtoId()).orElse(null));
                    item.setQuantidade(itensDTO.quantidade());
                    item.setPrecoUnitario(itensDTO.precoUnitario());
                    return item;
                }).toList();
    }

    public abstract PedidoResponseDTO toDTO(Pedido pedido);

    public Pedido toPedidoFromCarrinho(Carrinho carrinho, FormaPagamento formaPagamento, EnderecoRequestDTO enderecoEntrega) {
        Endereco endereco = enderecoMapper.toEntity(enderecoEntrega);
        Pedido pedido = new Pedido();
        pedido.setCliente(carrinho.getCliente());
        pedido.setItens(mapItensCarrinhoParaItensPedido(carrinho.getItens()));
        pedido.setTotalPedido(carrinhoService.obterValorCarrinho(carrinho.getId()));
        pedido.setFrete(BigDecimal.ZERO);
        pedido.setEnderecoEntrega(endereco);
        pedido.setFormaPagamento(formaPagamento);
        pedido.setStatus(StatusPedido.PENDENTE);
        return pedido;
    }

    private List<ItemPedido> mapItensCarrinhoParaItensPedido(List<ItemCarrinho> itensCarrinho) {
        return itensCarrinho.stream()
                .map(itemCarrinho -> {
                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setProduto(itemCarrinho.getProduto());
                    itemPedido.setQuantidade(itemCarrinho.getQuantidade());
                    itemPedido.setPrecoUnitario(itemCarrinho.getPrecoUnitario());
                    return itemPedido;
                }).toList();
    }
}
