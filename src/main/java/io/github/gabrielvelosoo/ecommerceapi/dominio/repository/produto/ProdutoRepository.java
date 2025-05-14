package io.github.gabrielvelosoo.ecommerceapi.dominio.repository.produto;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long>, JpaSpecificationExecutor<Produto> {

    List<Produto> findByCategoriaId(Long categoriaId);
}
