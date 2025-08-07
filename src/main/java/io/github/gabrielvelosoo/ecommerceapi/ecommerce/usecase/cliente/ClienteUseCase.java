package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.cliente;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteResponseDTO;

public interface ClienteUseCase {

    ClienteResponseDTO salvarCliente(ClienteRequestDTO clienteDTO);
    ClienteResponseDTO obterClientePorId(Long clienteId);
    ClienteResponseDTO editarCliente(Long clienteId, ClienteRequestDTO clienteDTO);
    void deletarCliente(Long clienteId);
}
