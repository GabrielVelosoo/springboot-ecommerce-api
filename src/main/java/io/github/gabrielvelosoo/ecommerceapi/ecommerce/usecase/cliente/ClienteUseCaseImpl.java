package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.cliente;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.cliente.Cliente;
import io.github.gabrielvelosoo.ecommerceapi.domain.service.cliente.ClienteService;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.cliente.ClienteMapper;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.cliente.ClienteValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteUseCaseImpl implements ClienteUseCase {

    private final ClienteService clienteService;
    private final ClienteMapper clienteMapper;
    private final ClienteValidator clienteValidator;

    @Override
    public ClienteResponseDTO salvarCliente(ClienteRequestDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        clienteValidator.validar(cliente);

        Optional.ofNullable(cliente.getEnderecos())
                .ifPresent(enderecos -> enderecos.forEach(e -> e.setCliente(cliente)));

        Cliente clienteSalvo = clienteService.salvarCliente(cliente);
        return clienteMapper.toDTO(clienteSalvo);
    }
}
