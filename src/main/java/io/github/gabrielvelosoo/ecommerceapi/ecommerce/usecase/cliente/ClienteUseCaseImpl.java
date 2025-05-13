package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.cliente;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.cliente.Cliente;
import io.github.gabrielvelosoo.ecommerceapi.dominio.service.cliente.ClienteService;
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

    @Override
    public ClienteResponseDTO editarCliente(Long clienteId, ClienteRequestDTO clienteDTO) {
        Cliente cliente = clienteService.obterClientePorId(clienteId);
        clienteValidator.validar(cliente);
        clienteMapper.editarCliente(cliente, clienteDTO);
        Cliente clienteEditado = clienteService.editarCliente(cliente);
        return clienteMapper.toDTO(clienteEditado);
    }

    @Override
    public void deletarCliente(Long clienteId) {
        Cliente cliente = clienteService.obterClientePorId(clienteId);
        clienteService.deletarCliente(cliente);
    }
}
