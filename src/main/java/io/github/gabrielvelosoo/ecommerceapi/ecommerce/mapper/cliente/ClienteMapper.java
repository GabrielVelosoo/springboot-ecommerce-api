package io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.cliente;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.carrinho.Carrinho;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.cliente.Cliente;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ClienteMapper {

    public abstract Cliente toEntity(ClienteRequestDTO clienteDTO);
    public abstract ClienteResponseDTO toDTO(Cliente cliente);

    public Cliente toEntityComCarrinho(ClienteRequestDTO clienteDTO) {
        Cliente cliente = toEntity(clienteDTO);
        Carrinho carrinho = new Carrinho();
        carrinho.setCliente(cliente);
        cliente.setCarrinho(carrinho);
        return cliente;
    }

    public void editarCliente(Cliente cliente, ClienteRequestDTO clienteDTO) {
        cliente.setNome(clienteDTO.nome());
        cliente.setSobrenome(clienteDTO.sobrenome());
        cliente.setCpf(clienteDTO.cpf());
        cliente.setDataNascimento(clienteDTO.dataNascimento());
    }
}
