package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.produto;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoResponseDTO;

import java.util.List;

public interface ProdutoUseCase {

    void salvarProduto(ProdutoRequestDTO produtoDTO);
    List<ProdutoResponseDTO> obterProdutos();
}
