package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EnderecoRequestDTO(
        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
        String nomeContato,

        @NotBlank(message = "Sobrenome é obrigatório")
        @Size(min = 2, max = 100, message = "Sobrenome deve ter entre 2 e 100 caracteres")
        String sobrenomeContato,

        @NotBlank(message = "Telefone é obrigatório")
        @Size(min = 11, max = 11, message = "O telefone deve ter 11 caracteres")
        String telefoneContato,

        @NotBlank(message = "Rua é obrigatório")
        @Size(min = 2, max = 150, message = "A rua deve ter entre 2 e 150 caracteres")
        String rua,

        @NotBlank(message = "Número é obrigatório")
        @Size(max = 10, message = "O número deve ter no máximo 10 caracteres")
        String numero,

        @NotBlank(message = "Bairro é obrigatório")
        @Size(min = 2, max = 100, message = "O bairro deve ter entre 2 e 100 caracteres")
        String bairro,

        @NotBlank(message = "Cidade é obrigatório")
        @Size(min = 2, max = 100, message = "A cidade deve ter entre 2 e 100 caracteres")
        String cidade,

        @NotBlank(message = "Estado é obrigatório")
        @Size(min = 2, max = 100, message = "O estado deve ter entre 2 e 100 caracteres")
        String estado,

        @NotBlank(message = "CEP é obrigatório")
        @Size(min = 8, max = 8, message = "O CEP deve ter 8 caracteres")
        String cep,

        @Size(max = 50, message = "O complemento deve ter no máximo 50 caracteres")
        String complemento
    ) {
}
