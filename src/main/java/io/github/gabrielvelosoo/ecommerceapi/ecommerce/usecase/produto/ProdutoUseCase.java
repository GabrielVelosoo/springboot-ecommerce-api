package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.produto;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoResponseDTO;

import java.util.List;

public interface ProdutoUseCase {

    ProdutoResponseDTO salvarProduto(ProdutoRequestDTO produtoDTO);
    List<ProdutoResponseDTO> obterProdutos();
    ProdutoResponseDTO editarProduto(Long produtoId, ProdutoRequestDTO produtoDTO);
}
