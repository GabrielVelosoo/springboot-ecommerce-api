package io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.cliente;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.cliente.Cliente;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.cliente.ClienteRepository;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.excecoes.RegistroDuplicadoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClienteValidator {

    private final ClienteRepository clienteRepository;

    public void validar(Cliente cliente) {
        if(clientePossuiEmailCadastrado(cliente)) {
           throw new RegistroDuplicadoException("O e-mail " + cliente.getEmail() + " já está cadastrado");
        }
    }

    public boolean clientePossuiEmailCadastrado(Cliente cliente) {
        Optional<Cliente> clienteOptional = clienteRepository.findByEmail(cliente.getEmail());
        if(cliente.getId() == null) {
            return clienteOptional.isPresent();
        }
        return clienteOptional
                .map(c -> !c.getId().equals(cliente.getId()))
                .orElse(false);
    }
}
