package io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.cliente;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.cliente.Cliente;
import io.github.gabrielvelosoo.ecommerceapi.domain.repository.cliente.ClienteRepository;
import io.github.gabrielvelosoo.ecommerceapi.infrastructure.exception.excecoes.RegistroDuplicadoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClienteValidator {

    private final ClienteRepository repository;

    public void validar(Cliente cliente) {
        if(clientePossuiCpfCadastrado(cliente)) {
           throw new RegistroDuplicadoException("Este CPF já está cadastrado");
        }
    }

    public boolean clientePossuiCpfCadastrado(Cliente cliente) {
        Optional<Cliente> clienteOptional = repository.findByCpf(cliente.getCpf());
        if(cliente.getId() == null) {
            return clienteOptional.isPresent();
        }
        return clienteOptional
                .map(c -> !c.getId().equals(cliente.getId()))
                .orElse(false);
    }
}
