package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto;

import java.math.BigDecimal;

public record ProdutoResponseDTO(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco,
        Integer quantidadeEstoque,
        String imagemUrl,
        CategoriaResponseDTO categoria
    ) {
}
