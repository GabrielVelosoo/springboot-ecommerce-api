package io.github.gabrielvelosoo.ecommerceapi.domain.repository.carrinho;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.carrinho.ItemCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Long> {
}
