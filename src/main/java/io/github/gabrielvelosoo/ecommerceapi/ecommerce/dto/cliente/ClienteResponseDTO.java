package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.cliente.Endereco;

import java.time.LocalDateTime;
import java.util.List;

public record ClienteResponseDTO(
        Long id,
        String nome,
        String cpf,
        String telefone,
        List<Endereco> enderecos,
        LocalDateTime dataCadastro,
        LocalDateTime dataAtualizacao
    ) {
}
