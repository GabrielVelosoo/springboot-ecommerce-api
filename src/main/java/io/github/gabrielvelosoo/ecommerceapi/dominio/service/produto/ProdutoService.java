package io.github.gabrielvelosoo.ecommerceapi.dominio.service.produto;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.produto.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ProdutoService {

    Produto salvaProduto(Produto produto);
    Produto obterProdutoPorId(Long produtoId);
    Page<Produto> obterProdutosPorNome(Specification<Produto> spec, Pageable paginacao);
    List<Produto> obterProdutosPorCategoria(Long categoriaId);
    Produto editarProduto(Produto produto);
    void deletarProduto(Produto produto);
}
