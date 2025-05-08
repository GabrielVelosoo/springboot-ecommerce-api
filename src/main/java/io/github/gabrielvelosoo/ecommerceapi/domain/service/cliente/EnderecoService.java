package io.github.gabrielvelosoo.ecommerceapi.domain.service.cliente;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.cliente.Endereco;

import java.util.List;

public interface EnderecoService {

    void salvarEndereco(Endereco endereco);
    List<Endereco> obterEnderecosClienteId(Long clienteId);
}
