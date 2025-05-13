package io.github.gabrielvelosoo.ecommerceapi.domain.service.cliente;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.cliente.Endereco;

import java.util.List;

public interface EnderecoService {

    Endereco salvarEndereco(Endereco endereco);
    Endereco obterEnderecoPorId(Long enderecoId);
    List<Endereco> obterEnderecosClienteId(Long clienteId);
    Endereco editarEndereco(Endereco endereco);
    void deletarEndereco(Endereco endereco);
}
