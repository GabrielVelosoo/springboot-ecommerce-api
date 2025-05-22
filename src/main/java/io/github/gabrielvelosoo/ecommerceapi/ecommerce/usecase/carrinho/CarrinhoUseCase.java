package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.carrinho;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.carrinho.CarrinhoResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.carrinho.ItemCarrinhoRequestDTO;

public interface CarrinhoUseCase {

    CarrinhoResponseDTO obterCarrinhoPorId(Long carrinhoId);
    void adicionarProdutoAoCarrinho(Long carrinhoId, ItemCarrinhoRequestDTO itemCarrinhoDTO);
    void diminuirQuantidadeProdutoDoCarrinho(Long carrinhoId, Long produtoId);
    void adicionarQuantidadeProdutoDoCarrinho(Long carrinhoId, Long produtoId);
    void removerProdutoDoCarrinho(Long carrinhoId, Long produtoId);
}
