package io.github.gabrielvelosoo.ecommerceapi.dominio.repository.produto.spec;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.produto.Produto;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProdutoSpecification {

    public static Specification<Produto> nomeLike(String produtoNome) {
        return (root, query, cb) -> cb.like( cb.upper(root.get("nome")),
                "%" + produtoNome.toUpperCase() + "%" );
    }

    public static Specification<Produto> precoMaiorOuIgual(BigDecimal precoMin) {
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("preco"), precoMin);
    }

    public static Specification<Produto> precoMenorOuIgual(BigDecimal precoMax) {
        return (root, query, cb) -> cb.lessThanOrEqualTo(root.get("preco"), precoMax);
    }

    public static Specification<Produto> estoqueMaiorOuIgual(Integer estoqueMin) {
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("estoque"), estoqueMin);
    }

    public static Specification<Produto> estoqueMenorOuIgual(Integer estoqueMax) {
        return (root, query, cb) -> cb.lessThanOrEqualTo(root.get("estoque"), estoqueMax);
    }

    public static Specification<Produto> categoriaIgual(Long categoriaId) {
        return (root, query, cb) -> cb.equal(root.get("categoria").get("id"), categoriaId);
    }
}
