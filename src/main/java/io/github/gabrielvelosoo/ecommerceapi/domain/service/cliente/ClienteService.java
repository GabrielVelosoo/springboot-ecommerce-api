package io.github.gabrielvelosoo.ecommerceapi.domain.service.cliente;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.cliente.Cliente;

public interface ClienteService {

    Cliente salvarCliente(Cliente cliente);
    Cliente obterClientePorId(Long id);
    Cliente editarCliente(Cliente cliente);
    void deletarCliente(Cliente cliente);
}
