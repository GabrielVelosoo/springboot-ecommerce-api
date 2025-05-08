package io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.cliente;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.cliente.Endereco;
import io.github.gabrielvelosoo.ecommerceapi.domain.repository.cliente.ClienteRepository;
import io.github.gabrielvelosoo.ecommerceapi.infrastructure.exception.excecoes.RegistroNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnderecoValidator {

    private final ClienteRepository clienteRepository;

    public void validar(Endereco endereco) {
        if(!clienteExiste(endereco)) {
            throw new RegistroNaoEncontradoException("Cliente não encontrado");
        }
    }

    public boolean clienteExiste(Endereco endereco) {
        if(endereco.getCliente() == null || endereco.getCliente().getId() == null) {
            return false;
        }
        return clienteRepository.existsById(endereco.getCliente().getId());
    }
}
