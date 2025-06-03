package io.github.gabrielvelosoo.ecommerceapi.dominio.service.cliente;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.cliente.Cliente;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.cliente.ClienteRepository;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.excecoes.RegistroNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Cliente salvarCliente(Cliente cliente) {
        String senha = cliente.getSenha();
        cliente.setSenha(passwordEncoder.encode(senha));
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
