package io.github.gabrielvelosoo.ecommerceapi.dominio.service.cliente;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.cliente.Cliente;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.cliente.ClienteRepository;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.excecoes.RegistroNaoEncontradoException;
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
    public Cliente obterClientePorKeycloakUsuarioId(String keycloakUsuarioId) {
        return clienteRepository.findByKeycloakUsuarioId(keycloakUsuarioId)
                .orElseThrow( () -> new RegistroNaoEncontradoException("Cliente com " + keycloakUsuarioId + "não encontrado"));
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
