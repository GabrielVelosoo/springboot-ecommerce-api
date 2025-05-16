package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.carrinho;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.carrinho.Carrinho;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.carrinho.ItemCarrinho;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.produto.Produto;
import io.github.gabrielvelosoo.ecommerceapi.dominio.service.carrinho.CarrinhoService;
import io.github.gabrielvelosoo.ecommerceapi.dominio.service.produto.ProdutoService;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.carrinho.CarrinhoResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.carrinho.CarrinhoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CarrinhoUseCaseImpl implements CarrinhoUseCase {

    private final CarrinhoService carrinhoService;
    private final ProdutoService produtoService;
    private final CarrinhoMapper carrinhoMapper;

    @Override
    public CarrinhoResponseDTO obterCarrinhoPorId(Long carrinhoId) {
        Carrinho carrinho = carrinhoService.obterCarrinhoPorId(carrinhoId);
        carrinho.setTotalCarrinho(obterValorCarrinho(carrinhoId));
        return carrinhoMapper.toDTO(carrinho);
    }

    @Override
    public void adicionarProdutoAoCarrinho(Long carrinhoId, Long produtoId, Integer quantidade) {
        Carrinho carrinho = carrinhoService.obterCarrinhoPorId(carrinhoId);
        Produto produto = produtoService.obterProdutoPorId(produtoId);

        Optional<ItemCarrinho> itemExistente = buscarItemPorProduto(carrinho, produtoId);

        if(itemExistente.isPresent()) {
            ItemCarrinho item = itemExistente.get();
            item.setQuantidade(item.getQuantidade() + quantidade);
        } else {
            ItemCarrinho novoItem = new ItemCarrinho(produto, carrinho, quantidade, produto.getPreco());
            carrinho.getItens().add(novoItem);
        }

        carrinhoService.salvarCarrinho(carrinho);
    }

    @Override
    public void diminuirQuantidadeProdutoDoCarrinho(Long carrinhoId, Long produtoId) {
        Carrinho carrinho = carrinhoService.obterCarrinhoPorId(carrinhoId);

        buscarItemPorProduto(carrinho, produtoId).ifPresent(item -> {
            if(item.getQuantidade() > 1) {
                item.setQuantidade(item.getQuantidade() - 1);
            } else {
                removerProdutoDoCarrinho(carrinhoId, produtoId);
            }
            carrinhoService.salvarCarrinho(carrinho);
        });
    }

    @Override
    public void adicionarQuantidadeProdutoDoCarrinho(Long carrinhoId, Long produtoId) {
        Carrinho carrinho = carrinhoService.obterCarrinhoPorId(carrinhoId);
        buscarItemPorProduto(carrinho, produtoId).ifPresent(item -> {
            item.setQuantidade(item.getQuantidade() + 1);
            carrinhoService.salvarCarrinho(carrinho);
        });
    }

    public Optional<ItemCarrinho> buscarItemPorProduto(Carrinho carrinho, Long produtoId) {
        return carrinho.getItens()
                .stream()
                .filter(item -> item.getProduto().getId().equals(produtoId))
                .findFirst();
    }

    @Override
    public void removerProdutoDoCarrinho(Long carrinhoId, Long produtoId) {
        Carrinho carrinho = carrinhoService.obterCarrinhoPorId(carrinhoId);
        Produto produto = produtoService.obterProdutoPorId(produtoId);
        carrinho.getItens().removeIf(item -> item.getProduto().equals(produto));
        carrinhoService.salvarCarrinho(carrinho);
    }

    @Override
    public BigDecimal obterValorCarrinho(Long carrinhoId) {
        Carrinho carrinho = carrinhoService.obterCarrinhoPorId(carrinhoId);
        BigDecimal totalCarrinho = calcularValorCarrinho(carrinho);
        carrinho.setTotalCarrinho(totalCarrinho);
        return totalCarrinho;
    }

    public BigDecimal calcularValorCarrinho(Carrinho carrinho) {
        BigDecimal totalCarrinho = BigDecimal.ZERO;
        for(ItemCarrinho item : carrinho.getItens()) {
            BigDecimal precoUnitario = item.getPrecoUnitario();
            Integer quantidade = item.getQuantidade();
            BigDecimal totalItem = precoUnitario.multiply(BigDecimal.valueOf(quantidade));
            totalCarrinho = totalCarrinho.add(totalItem);
        }
        return totalCarrinho;
    }
}
