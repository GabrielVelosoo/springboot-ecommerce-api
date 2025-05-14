package io.github.gabrielvelosoo.ecommerceapi.dominio.repository.produto.spec;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.produto.Produto;
import org.springframework.data.jpa.domain.Specification;

public class ProdutoSpecification {

    public static Specification<Produto> filtrarPorNome(String produtoNome) {
        if (produtoNome == null || produtoNome.trim().isEmpty()) {
            return null;
        }
        return (root, query, cb) -> cb.like( cb.upper(root.get("nome")), "%" + produtoNome.toUpperCase() + "%" );
    }
}
