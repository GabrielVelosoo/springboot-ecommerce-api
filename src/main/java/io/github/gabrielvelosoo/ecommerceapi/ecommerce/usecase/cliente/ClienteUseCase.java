package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.cliente;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteRequestDTO;

public interface ClienteUseCase {

    void salvarCliente(ClienteRequestDTO clienteDTO);
}
