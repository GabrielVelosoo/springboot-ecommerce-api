package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.cliente;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.cliente.Endereco;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Usuario;
import io.github.gabrielvelosoo.ecommerceapi.dominio.service.cliente.EnderecoService;
import io.github.gabrielvelosoo.ecommerceapi.dominio.service.usuario.UsuarioService;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.EnderecoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.EnderecoResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.cliente.EnderecoMapper;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.custom.cliente.EnderecoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EnderecoUseCaseImpl implements EnderecoUseCase {

    private final EnderecoService enderecoService;
    private final UsuarioService usuarioService;
    private final EnderecoMapper enderecoMapper;
    private final EnderecoValidator enderecoValidator;

    @Override
    public EnderecoResponseDTO salvarEndereco(EnderecoRequestDTO enderecoDTO) {
        Endereco endereco = enderecoMapper.toEntity(enderecoDTO);
        enderecoValidator.validar(endereco);
        Endereco enderecoSalvo = enderecoService.salvarEndereco(endereco);
        return enderecoMapper.toDTO(enderecoSalvo);
    }

    @Override
    public List<EnderecoResponseDTO> obterEnderecosUsuarioLogado() {
        Usuario usuario = usuarioService.obterUsuarioLogado();
        List<Endereco> enderecos = enderecoService.obterEnderecosUsuarioLogado(usuario.getId());
        return enderecoMapper.toDTOs(enderecos);
    }

    @Override
    public EnderecoResponseDTO editarEndereco(Long enderecoId, EnderecoRequestDTO enderecoDTO) {
        Endereco endereco = enderecoService.obterEnderecoPorId(enderecoId);
        enderecoValidator.validar(endereco);
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
