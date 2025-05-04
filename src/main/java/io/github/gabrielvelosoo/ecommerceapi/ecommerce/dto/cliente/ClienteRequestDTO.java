package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.cliente.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

public record ClienteRequestDTO(
        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
        String nome,

        @CPF
        @NotBlank(message = "CPF é obrigatório")
        String cpf,

        @NotBlank(message = "Telefone é obrigatório")
        @Size(min = 12, max = 15, message = "O telefone deve ter entre 12 e 15 caracteres")
        String telefone,
        List<Endereco> enderecos
    ) {
}
