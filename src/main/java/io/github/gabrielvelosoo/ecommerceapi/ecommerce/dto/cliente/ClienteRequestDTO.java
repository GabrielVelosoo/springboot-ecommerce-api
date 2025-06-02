package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.cliente.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;
import java.util.List;

public record ClienteRequestDTO(
        @Email
        @NotBlank
        String email,

        @NotBlank
        String senha,

        @NotBlank
        @Size(min = 2, max = 100)
        String nome,

        @NotBlank
        String sobrenome,

        @CPF
        @NotBlank
        String cpf,

        @NotBlank
        @Size(min = 11, max = 11)
        String telefone,

        LocalDateTime dataNascimento,

        List<Endereco> enderecos
    ) {
}
