package io.github.gabrielvelosoo.ecommerceapi.dominio.service.cliente;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.cliente.Endereco;

import java.util.List;

public interface EnderecoService {

    Endereco salvarEndereco(Endereco endereco);
    Endereco obterEnderecoPorId(Long enderecoId);
    List<Endereco> obterEnderecosUsuarioLogado(Long usuarioId);
    Endereco editarEndereco(Endereco endereco);
    void deletarEndereco(Endereco endereco);
}
