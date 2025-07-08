package io.github.gabrielvelosoo.ecommerceapi.dominio.repository.produto;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.produto.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findByNomeAndCategoriaPai(String nome, Categoria categoriaPai);
    List<Categoria> findByCategoriaPaiIsNull();
}
