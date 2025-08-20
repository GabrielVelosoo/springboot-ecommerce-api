package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.groups.ValidaDemais;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.groups.ValidaNotBlank;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public record ProdutoRequestDTO(
        @NotBlank(message = "Nome é obrigatório", groups = ValidaNotBlank.class)
        @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres", groups = ValidaDemais.class)
        String nome,

        @NotBlank(message = "Descrição é obrigatório", groups = ValidaNotBlank.class)
        @Size(min = 5, message = "Descrição deve ter no mínimo 5 caracteres", groups = ValidaDemais.class)
        String descricao,

        @NotNull(message = "Preço é obrigatório", groups = ValidaNotBlank.class)
        @Positive(message = "Preço deve ser maior que zero", groups = ValidaNotBlank.class)
        BigDecimal preco,

        @NotNull(message = "Quantidade é obrigatório", groups = ValidaNotBlank.class)
        @Positive(message = "Quantidade deve ser maior que zero", groups = ValidaNotBlank.class)
        Integer quantidadeEstoque,

        @NotNull(message = "Imagem é obrigatório", groups = ValidaNotBlank.class)
        MultipartFile imagem,

        @NotNull(message = "Categoria é obrigatório", groups = ValidaNotBlank.class)
        Long categoriaId
    ) {
}
