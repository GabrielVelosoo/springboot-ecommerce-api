package io.github.gabrielvelosoo.ecommerceapi.dominio.repository.produto.spec;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.produto.Produto;
import org.springframework.data.jpa.domain.Specification;

public class ProdutoSpecification {

    public static Specification<Produto> nomeLike(String produtoNome) {
        return (root, query, cb) -> cb.like( cb.upper(root.get("nome")), "%" + produtoNome.toUpperCase() + "%" );
    }
}
