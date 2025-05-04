package io.github.gabrielvelosoo.ecommerceapi.domain.repository.produto;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
