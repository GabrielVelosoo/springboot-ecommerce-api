package io.github.gabrielvelosoo.ecommerceapi.dominio.service.produto;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.produto.Categoria;

import java.util.List;

public interface CategoriaService {

    Categoria salvarCategoria(Categoria categoria);
    List<Categoria> obterCategoriasRaizes();
    Categoria obterCategoriaPorId(Long id);
    Categoria obterCategoriaPorSlug(String slug);
}
