package io.github.gabrielvelosoo.ecommerceapi.domain.repository.produto;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.produto.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findByNome(String nome);
}
