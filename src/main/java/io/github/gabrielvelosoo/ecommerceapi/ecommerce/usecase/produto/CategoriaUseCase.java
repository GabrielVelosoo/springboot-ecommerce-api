package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.produto;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.CategoriaRequestDTO;

public interface CategoriaUseCase {

    void salvarCategoria(CategoriaRequestDTO categoriaDTO);
}
