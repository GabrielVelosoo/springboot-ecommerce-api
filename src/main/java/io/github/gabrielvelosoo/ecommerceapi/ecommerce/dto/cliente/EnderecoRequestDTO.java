package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.groups.ValidaDemais;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.groups.ValidaNotBlank;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EnderecoRequestDTO(
        @NotBlank(message = "Nome é obrigatório", groups = ValidaNotBlank.class)
        @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres", groups = ValidaDemais.class)
        String nomeContato,

        @NotBlank(message = "Sobrenome é obrigatório", groups = ValidaNotBlank.class)
        @Size(min = 2, max = 100, message = "Sobrenome deve ter entre 2 e 100 caracteres", groups = ValidaDemais.class)
        String sobrenomeContato,

        @NotBlank(message = "Telefone é obrigatório", groups = ValidaNotBlank.class)
        @Size(min = 11, max = 11, message = "O telefone deve ter 11 caracteres", groups = ValidaDemais.class)
        String telefoneContato,

        @NotBlank(message = "Endereço é obrigatório", groups = ValidaNotBlank.class)
        @Size(min = 2, max = 150, message = "O endereço deve ter entre 2 e 150 caracteres", groups = ValidaDemais.class)
        String endereco,

        @NotBlank(message = "Número é obrigatório", groups = ValidaNotBlank.class)
        @Size(max = 10, message = "O número deve ter no máximo 10 caracteres", groups = ValidaDemais.class)
        String numero,

        @NotBlank(message = "Bairro é obrigatório", groups = ValidaNotBlank.class)
        @Size(min = 2, max = 100, message = "O bairro deve ter entre 2 e 100 caracteres", groups = ValidaDemais.class)
        String bairro,

        @NotBlank(message = "Cidade é obrigatório", groups = ValidaNotBlank.class)
        @Size(min = 2, max = 100, message = "A cidade deve ter entre 2 e 100 caracteres", groups = ValidaDemais.class)
        String cidade,

        @NotBlank(message = "Estado é obrigatório", groups = ValidaNotBlank.class)
        @Size(min = 2, max = 100, message = "O estado deve ter entre 2 e 100 caracteres", groups = ValidaDemais.class)
        String estado,

        @NotBlank(message = "CEP é obrigatório", groups = ValidaNotBlank.class)
        @Size(min = 8, max = 8, message = "O CEP deve ter 8 caracteres", groups = ValidaDemais.class)
        String cep,

        @Size(max = 50, message = "O complemento deve ter no máximo 50 caracteres", groups = ValidaDemais.class)
        String complemento
    ) {
}
