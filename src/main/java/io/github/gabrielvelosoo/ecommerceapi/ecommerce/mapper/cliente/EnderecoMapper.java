package io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.cliente;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.cliente.Endereco;
import io.github.gabrielvelosoo.ecommerceapi.domain.repository.cliente.ClienteRepository;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.EnderecoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.EnderecoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = ClienteMapper.class)
public abstract class EnderecoMapper {

    @Autowired
    ClienteRepository clienteRepository;

    @Mapping(target = "cliente", expression = "java( clienteRepository.findById(enderecoDTO.clienteId()).orElse(null) )")
    public abstract Endereco toEntity(EnderecoRequestDTO enderecoDTO);

    public abstract EnderecoResponseDTO toDTO(Endereco endereco);
    public abstract List<EnderecoResponseDTO> toDTOs(List<Endereco> enderecos);

    public void editarEndereco(Endereco endereco, EnderecoRequestDTO enderecoDTO) {
        endereco.setNomeContato(enderecoDTO.nomeContato());
        endereco.setTelefoneContato(enderecoDTO.telefoneContato());
        endereco.setRua(enderecoDTO.rua());
        endereco.setNumero(enderecoDTO.numero());
        endereco.setBairro(enderecoDTO.bairro());
        endereco.setCidade(enderecoDTO.cidade());
        endereco.setCep(enderecoDTO.cep());
        endereco.setComplemento(enderecoDTO.complemento());
    }
}
