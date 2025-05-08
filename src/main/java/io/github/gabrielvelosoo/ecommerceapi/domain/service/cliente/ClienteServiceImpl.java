package io.github.gabrielvelosoo.ecommerceapi.domain.service.cliente;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.cliente.Cliente;
import io.github.gabrielvelosoo.ecommerceapi.domain.repository.cliente.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public void salvarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }
}
