package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public record EnderecoResponseDTO(
        Long id,
        String nomeContato,
        String sobrenomeContato,
        String telefoneContato,
        String endereco,
        String numero,
        String bairro,
        String cidade,
        String estado,

        @JsonIgnore
        String cep,
        String complemento
    ) {

    @JsonGetter("cep")
    public String getCepFormatado() {
        if(cep == null || cep.length() != 8) return cep;
        return cep.replaceAll("(\\d{5})(\\d{3})", "$1-$2");
    }
}
