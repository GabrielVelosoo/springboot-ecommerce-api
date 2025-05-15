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

@Component
@RequiredArgsConstructor
public class CarrinhoUseCaseImpl implements CarrinhoUseCase {

    private final CarrinhoService carrinhoService;
    private final ProdutoService produtoService;
    private final CarrinhoMapper carrinhoMapper;

    @Override
    public CarrinhoResponseDTO obterCarrinhoPorId(Long carrinhoId) {
        Carrinho carrinho = carrinhoService.obterCarrinhoPorId(carrinhoId);
        return carrinhoMapper.toDTO(carrinho);
    }

    @Override
    public void adicionarProdutoAoCarrinho(Long carrinhoId, Long produtoId, Integer quantidade) {
        Carrinho carrinho = carrinhoService.obterCarrinhoPorId(carrinhoId);
        Produto produto = produtoService.obterProdutoPorId(produtoId);

        ItemCarrinho item = new ItemCarrinho(produto, carrinho, quantidade, produto.getPreco());
        carrinho.getItens().add(item);

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
