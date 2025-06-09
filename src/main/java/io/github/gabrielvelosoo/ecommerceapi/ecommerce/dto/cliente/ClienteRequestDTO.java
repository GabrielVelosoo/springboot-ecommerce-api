package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.groups.ValidaDemais;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.groups.ValidaNotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record ClienteRequestDTO(
        @Email(message = "Endereço de e-mail inválido", groups = ValidaDemais.class)
        @NotBlank(message = "Campo obrigatório", groups = ValidaNotBlank.class)
        String email,

        @NotBlank(message = "Campo obrigatório", groups = ValidaNotBlank.class)
        String senha,

        @NotBlank(message = "Campo obrigatório", groups = ValidaNotBlank.class)
        @Size(min = 2, max = 100, message = "Deve ter entre 2 a 100 caracteres", groups = ValidaDemais.class)
        String nome,

        @NotBlank(message = "Campo obrigatório", groups = ValidaNotBlank.class)
        String sobrenome,

        @CPF(message = "CPF inválido", groups = ValidaDemais.class)
        @NotBlank(message = "Campo obrigatório", groups = ValidaNotBlank.class)
        String cpf,

        @NotBlank(message = "Campo obrigatório", groups = ValidaNotBlank.class)
        String cep,

        @NotNull(message = "Campo obrigatório")
        LocalDate dataNascimento
    ) {
}
