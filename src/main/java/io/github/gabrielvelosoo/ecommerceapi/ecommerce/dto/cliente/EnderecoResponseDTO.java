package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente;

public record EnderecoResponseDTO(
        Long id,
        String nomeContato,
        String telefoneContato,
        String rua,
        String numero,
        String bairro,
        String cidade,
        String estado,
        String cep,
        String complemento
    ) {
}
