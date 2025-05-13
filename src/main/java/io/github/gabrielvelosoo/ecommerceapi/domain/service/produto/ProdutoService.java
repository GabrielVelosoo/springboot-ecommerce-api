package io.github.gabrielvelosoo.ecommerceapi.domain.service.produto;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.produto.Produto;

import java.util.List;

public interface ProdutoService {

    Produto salvaProduto(Produto produto);
    List<Produto> obterProdutos();
    Produto obterProdutoPorId(Long produtoId);
    Produto editarProduto(Produto produto);
    void deletarProduto(Produto produto);
}
