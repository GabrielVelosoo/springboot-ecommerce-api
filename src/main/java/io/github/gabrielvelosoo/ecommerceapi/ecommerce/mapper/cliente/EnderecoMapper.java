package io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.cliente;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.cliente.Endereco;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.EnderecoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.EnderecoResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ClienteMapper.class)
public abstract class EnderecoMapper {

    public abstract Endereco toEntity(EnderecoRequestDTO enderecoDTO);

    public abstract EnderecoResponseDTO toDTO(Endereco endereco);
    public abstract List<EnderecoResponseDTO> toDTOs(List<Endereco> enderecos);

    public void editarEndereco(Endereco endereco, EnderecoRequestDTO enderecoDTO) {
        endereco.setNomeContato(enderecoDTO.nomeContato());
        endereco.setSobrenomeContato(enderecoDTO.sobrenomeContato());
        endereco.setTelefoneContato(enderecoDTO.telefoneContato());
        endereco.setEndereco(enderecoDTO.endereco());
        endereco.setNumero(enderecoDTO.numero());
        endereco.setBairro(enderecoDTO.bairro());
        endereco.setCidade(enderecoDTO.cidade());
        endereco.setCep(enderecoDTO.cep());
        endereco.setComplemento(enderecoDTO.complemento());
    }
}
