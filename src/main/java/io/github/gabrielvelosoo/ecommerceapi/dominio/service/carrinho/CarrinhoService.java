package io.github.gabrielvelosoo.ecommerceapi.dominio.service.carrinho;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.carrinho.Carrinho;

public interface CarrinhoService {

    void salvarCarrinho(Carrinho carrinho);
    Carrinho obterCarrinhoPorId(Long carrinhoId);
}
