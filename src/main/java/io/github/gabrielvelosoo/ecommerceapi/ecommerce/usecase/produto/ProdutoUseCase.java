package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.produto;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoRequestDTO;

public interface ProdutoUseCase {

    void salvarProduto(ProdutoRequestDTO produtoDTO);
}
