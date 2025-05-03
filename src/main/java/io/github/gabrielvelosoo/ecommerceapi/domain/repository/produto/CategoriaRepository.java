package io.github.gabrielvelosoo.ecommerceapi.domain.repository.produto;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
