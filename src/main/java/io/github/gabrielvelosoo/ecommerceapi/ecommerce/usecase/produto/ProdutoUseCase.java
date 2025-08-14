package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.produto;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoResponseDTO;

import java.io.IOException;
import java.util.List;

public interface ProdutoUseCase {

    ProdutoResponseDTO salvarProduto(ProdutoRequestDTO produtoDTO) throws IOException;
    List<ProdutoResponseDTO> obterProdutosPorNome(String produtoNome);
    List<ProdutoResponseDTO> obterProdutosPorCategoria(Long categoriaId);
    ProdutoResponseDTO editarProduto(Long produtoId, ProdutoRequestDTO produtoDTO);
    void deletarProduto(Long produtoId);
}
