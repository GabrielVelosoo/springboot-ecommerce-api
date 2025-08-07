package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.cliente;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.cliente.Cliente;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Role;
import io.github.gabrielvelosoo.ecommerceapi.dominio.service.cliente.ClienteService;
import io.github.gabrielvelosoo.ecommerceapi.dominio.service.usuario.RoleService;
import io.github.gabrielvelosoo.ecommerceapi.dominio.service.usuario.UsuarioService;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.cliente.ClienteMapper;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.custom.cliente.ClienteValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteUseCaseImpl implements ClienteUseCase {

    private final ClienteService clienteService;
    private final UsuarioService usuarioService;
    private final RoleService roleService;
    private final ClienteMapper clienteMapper;
    private final ClienteValidator clienteValidator;

    @Override
    @Transactional
    public ClienteResponseDTO salvarCliente(ClienteRequestDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntityComCarrinho(clienteDTO);
        clienteValidator.validar(cliente);
        Cliente clienteSalvo = clienteService.salvarCliente(cliente);
        Role role = roleService.obterRolePorNome("USER");
        usuarioService.adicionarRoleUser(clienteSalvo, role);
        return clienteMapper.toDTO(clienteSalvo);
    }

    @Override
    public ClienteResponseDTO obterClientePorId(Long clienteId) {
        Cliente cliente = clienteService.obterClientePorId(clienteId);
        return clienteMapper.toDTO(cliente);
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
