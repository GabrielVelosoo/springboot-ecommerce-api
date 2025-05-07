package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.cliente;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.cliente.Cliente;
import io.github.gabrielvelosoo.ecommerceapi.domain.service.cliente.ClienteService;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.cliente.ClienteMapper;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.cliente.ClienteValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteUseCaseImpl implements ClienteUseCase {

    private final ClienteService service;
    private final ClienteMapper clienteMapper;
    private final ClienteValidator validator;

    @Override
    public void salvarCliente(ClienteRequestDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        validator.validar(cliente);
        if(cliente.getEnderecos() != null && !cliente.getEnderecos().isEmpty()) {
            cliente.getEnderecos()
                    .forEach(e -> e.setCliente(cliente));
        }
        service.salvarCliente(cliente);
    }
}
