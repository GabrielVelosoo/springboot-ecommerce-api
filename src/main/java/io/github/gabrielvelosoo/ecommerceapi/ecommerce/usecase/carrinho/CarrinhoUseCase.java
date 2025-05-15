package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.carrinho;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.carrinho.CarrinhoResponseDTO;

import java.math.BigDecimal;

public interface CarrinhoUseCase {

    CarrinhoResponseDTO obterCarrinhoPorId(Long carrinhoId);
    void adicionarProdutoAoCarrinho(Long carrinhoId, Long produtoId, Integer quantidade);
    BigDecimal obterValorCarrinho(Long carrinhoId);
}
