package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.cliente;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.cliente.Cliente;
import io.github.gabrielvelosoo.ecommerceapi.domain.entity.cliente.Endereco;
import io.github.gabrielvelosoo.ecommerceapi.domain.service.cliente.ClienteService;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.cliente.ClienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteUseCaseImpl implements ClienteUseCase {

    private final ClienteService service;
    private final ClienteMapper clienteMapper;

    @Override
    public void salvarCliente(ClienteRequestDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        if(cliente != null && cliente.getEnderecos() != null) {
            for(Endereco endereco : cliente.getEnderecos()) {
                endereco.setCliente(cliente);
            }
        }
        service.salvarCliente(cliente);
    }
}
