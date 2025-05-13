package io.github.gabrielvelosoo.ecommerceapi.domain.service.cliente;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.cliente.Cliente;
import io.github.gabrielvelosoo.ecommerceapi.domain.repository.cliente.ClienteRepository;
import io.github.gabrielvelosoo.ecommerceapi.infrastructure.exception.excecoes.RegistroNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente obterClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow( () -> new RegistroNaoEncontradoException("Cliente não encontrado") );
    }

    @Override
    public Cliente editarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deletarCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
    }
}
