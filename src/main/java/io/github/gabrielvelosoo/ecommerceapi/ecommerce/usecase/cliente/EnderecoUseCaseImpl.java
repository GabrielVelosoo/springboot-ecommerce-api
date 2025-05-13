package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.cliente;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.cliente.Endereco;
import io.github.gabrielvelosoo.ecommerceapi.domain.service.cliente.EnderecoService;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.EnderecoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.EnderecoResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.cliente.EnderecoMapper;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.cliente.EnderecoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EnderecoUseCaseImpl implements EnderecoUseCase {

    private final EnderecoService enderecoService;
    private final EnderecoMapper enderecoMapper;
    private final EnderecoValidator enderecoValidator;

    @Override
    public EnderecoResponseDTO salvarEndereco(EnderecoRequestDTO enderecoDTO) {
        Endereco endereco = enderecoMapper.toEntity(enderecoDTO);
        enderecoValidator.validar(endereco, enderecoDTO);
        Endereco enderecoSalvo = enderecoService.salvarEndereco(endereco);
        return enderecoMapper.toDTO(enderecoSalvo);
    }

    @Override
    public List<EnderecoResponseDTO> obterEnderecosClienteId(Long clienteId) {
        List<Endereco> enderecos = enderecoService.obterEnderecosClienteId(clienteId);
        return enderecoMapper.toDTOs(enderecos);
    }

    @Override
    public EnderecoResponseDTO editarEndereco(Long enderecoId, EnderecoRequestDTO enderecoDTO) {
        Endereco endereco = enderecoService.obterEnderecoPorId(enderecoId);
        enderecoValidator.validar(endereco, enderecoDTO);
        enderecoMapper.editarEndereco(endereco, enderecoDTO);
        Endereco enderecoEditado = enderecoService.editarEndereco(endereco);
        return enderecoMapper.toDTO(enderecoEditado);
    }

    @Override
    public void deletarEndereco(Long enderecoId) {
        Endereco endereco = enderecoService.obterEnderecoPorId(enderecoId);
        enderecoService.deletarEndereco(endereco);
    }
}
