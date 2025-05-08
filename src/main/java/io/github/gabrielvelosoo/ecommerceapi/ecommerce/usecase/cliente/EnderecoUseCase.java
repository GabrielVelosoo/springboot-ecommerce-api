package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.cliente;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.EnderecoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.EnderecoResponseDTO;

import java.util.List;

public interface EnderecoUseCase {

    void salvarEndereco(EnderecoRequestDTO enderecoDTO);
    List<EnderecoResponseDTO> obterEnderecosClienteId(Long clienteId);
}
