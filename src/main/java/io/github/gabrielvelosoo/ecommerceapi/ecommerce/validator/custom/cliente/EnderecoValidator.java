package io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.custom.cliente;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.cliente.Endereco;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.cliente.ClienteRepository;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.EnderecoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.excecoes.RegistroNaoEncontradoException;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.excecoes.RegraNegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnderecoValidator {

    private final ClienteRepository clienteRepository;

    public void validar(Endereco endereco, EnderecoRequestDTO enderecoDTO) {
        if(!clienteExiste(endereco)) {
            throw new RegistroNaoEncontradoException("Cliente não encontrado");
        }

        if(!verificaCamposImutaveis(endereco, enderecoDTO)) {
            throw new RegraNegocioException("Não é permitido alterar o cliente associado ao endereço");
        }
    }

    public boolean clienteExiste(Endereco endereco) {
        if(endereco.getCliente() == null || endereco.getCliente().getId() == null) {
            return false;
        }
        return clienteRepository.existsById(endereco.getCliente().getId());
    }

    public boolean verificaCamposImutaveis(Endereco endereco, EnderecoRequestDTO enderecoDTO) {
        return enderecoDTO.clienteId() == null
                || enderecoDTO.clienteId().equals(endereco.getCliente().getId());
    }
}
