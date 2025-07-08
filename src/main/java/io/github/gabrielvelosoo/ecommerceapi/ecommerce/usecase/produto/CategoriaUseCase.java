package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.produto;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.CategoriaRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.CategoriaResponseDTO;

import java.util.List;

public interface CategoriaUseCase {

    CategoriaResponseDTO salvarCategoria(CategoriaRequestDTO categoriaDTO);
    List<CategoriaResponseDTO> obterCategoriasRaizes();
}
