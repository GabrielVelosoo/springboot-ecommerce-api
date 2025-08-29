package io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.pedido;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.carrinho.Carrinho;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.carrinho.ItemCarrinho;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.cliente.Cliente;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.cliente.Endereco;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.pedido.FormaPagamento;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.pedido.ItemPedido;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.pedido.Pedido;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.pedido.StatusPedido;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.produto.Produto;
import io.github.gabrielvelosoo.ecommerceapi.dominio.service.cliente.ClienteService;
import io.github.gabrielvelosoo.ecommerceapi.dominio.service.produto.ProdutoService;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.EnderecoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido.ItemPedidoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido.PedidoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido.PedidoResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.cliente.ClienteMapper;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.cliente.EnderecoMapper;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.produto.ProdutoMapper;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class, ProdutoMapper.class, EnderecoMapper.class, ItemPedidoMapper.class})
public abstract class PedidoMapper {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ProdutoService produtoService;

    @Autowired
    private EnderecoMapper enderecoMapper;

    public abstract PedidoResponseDTO toDTO(Pedido pedido);

    public Pedido toEntity(PedidoRequestDTO pedidoDTO) {
        Cliente cliente = clienteService.obterClientePorId(2L);
        Endereco endereco = enderecoMapper.toEntity(pedidoDTO.enderecoEntrega());
        endereco.setCliente(cliente);
        Pedido pedido = new Pedido();
        pedido.setCliente(clienteService.obterClientePorId(pedidoDTO.clienteId()));
        pedido.setItens(mapItensPedido(pedidoDTO.itens()));
        pedido.setFormaPagamento(pedidoDTO.formaPagamento());
        pedido.setStatus(StatusPedido.PENDENTE);
        pedido.setEnderecoEntrega(endereco);
        pedido.setFrete(BigDecimal.ZERO);
        return pedido;
    }

    private List<ItemPedido> mapItensPedido(List<ItemPedidoRequestDTO> itensPedidoDTO) {
        if(itensPedidoDTO == null) return null;
        return itensPedidoDTO.stream()
                .map(itensDTO -> {
                    Produto produto = produtoService.obterProdutoPorId(itensDTO.produtoId());
                    ItemPedido item = new ItemPedido();
                    item.setProduto(produto);
                    item.setQuantidade(itensDTO.quantidade());
                    item.setPrecoUnitario(produto.getPreco());
                    return item;
                }).toList();
    }

    public Pedido toEntityFromCarrinho(Carrinho carrinho, FormaPagamento formaPagamento, EnderecoRequestDTO enderecoEntrega) {
        Cliente cliente = clienteService.obterClientePorId(carrinho.getCliente().getId());
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setItens(mapItensCarrinhoParaItensPedido(carrinho.getItens()));
        pedido.setFrete(BigDecimal.ZERO);
        pedido.setEnderecoEntrega(enderecoMapper.toEntity(enderecoEntrega));
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
