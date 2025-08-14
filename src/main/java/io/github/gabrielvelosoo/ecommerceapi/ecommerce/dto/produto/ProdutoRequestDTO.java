package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public record ProdutoRequestDTO(
        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
        String nome,

        @NotBlank(message = "Descrição é obrigatório")
        @Size(min = 5, message = "Descrição deve ter no mínimo 5 caracteres")
        String descricao,

        @NotNull(message = "Preço é obrigatório")
        BigDecimal preco,

        @NotNull(message = "Quantidade é obrigatório")
        Integer quantidadeEstoque,

        @NotNull(message = "Imagem é obrigatório")
        MultipartFile imagem,

        @NotNull(message = "Categoria é obrigatório")
        Long categoriaId
    ) {
}
