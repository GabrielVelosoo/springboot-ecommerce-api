package io.github.gabrielvelosoo.ecommerceapi.domain.service.produto;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.produto.Categoria;

import java.util.List;

public interface CategoriaService {

    Categoria salvarCategoria(Categoria categoria);
    List<Categoria> obterCategorias();
}
