package io.github.gabrielvelosoo.ecommerceapi.domain.service.produto;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.produto.Produto;

import java.util.List;

public interface ProdutoService {

    void salvaProduto(Produto produto);
    List<Produto> obterProdutos();
}
