package io.github.gabrielvelosoo.ecommerceapi.domain.service.cliente;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.cliente.Endereco;
import io.github.gabrielvelosoo.ecommerceapi.domain.repository.cliente.ClienteRepository;
import io.github.gabrielvelosoo.ecommerceapi.domain.repository.cliente.EnderecoRepository;
import io.github.gabrielvelosoo.ecommerceapi.infrastructure.exception.excecoes.RegistroNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final ClienteRepository clienteRepository;

    @Override
    public Endereco salvarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco obterEnderecoPorId(Long enderecoId) {
        return enderecoRepository.findById(enderecoId)
                .orElseThrow( () -> new RegistroNaoEncontradoException("Endereço não encontrado") );
    }

    @Override
    public List<Endereco> obterEnderecosClienteId(Long clienteId) {
        if(!clienteRepository.existsById(clienteId)) {
            throw new RegistroNaoEncontradoException("Cliente não encontrado");
        }
        return enderecoRepository.findByClienteId(clienteId);
    }

    @Override
    public Endereco editarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public void deletarEndereco(Endereco endereco) {
        enderecoRepository.delete(endereco);
    }
}
