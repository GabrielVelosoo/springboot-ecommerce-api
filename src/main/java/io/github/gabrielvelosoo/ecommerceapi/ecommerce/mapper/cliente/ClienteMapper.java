package io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.cliente;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.cliente.Cliente;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ClienteMapper {

    public abstract Cliente toEntity(ClienteRequestDTO clienteDTO);
    public abstract ClienteResponseDTO toDTO(Cliente cliente);

    public void editarCliente(Cliente cliente, ClienteRequestDTO clienteDTO) {
        cliente.setNome(clienteDTO.nome());
        cliente.setCpf(clienteDTO.cpf());
        cliente.setTelefone(clienteDTO.telefone());
    }
}
