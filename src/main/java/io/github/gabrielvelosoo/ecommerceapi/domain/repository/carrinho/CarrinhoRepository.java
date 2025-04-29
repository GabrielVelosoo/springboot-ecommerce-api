package io.github.gabrielvelosoo.ecommerceapi.domain.repository.carrinho;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}
