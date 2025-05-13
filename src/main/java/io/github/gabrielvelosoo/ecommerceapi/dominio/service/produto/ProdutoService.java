package io.github.gabrielvelosoo.ecommerceapi.dominio.service.produto;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.produto.Produto;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ProdutoService {

    Produto salvaProduto(Produto produto);
    List<Produto> obterProdutos();
    Produto obterProdutoPorId(Long produtoId);
    List<Produto> obterProdutosPorNome(Specification<Produto> spec);
    Produto editarProduto(Produto produto);
    void deletarProduto(Produto produto);
}
