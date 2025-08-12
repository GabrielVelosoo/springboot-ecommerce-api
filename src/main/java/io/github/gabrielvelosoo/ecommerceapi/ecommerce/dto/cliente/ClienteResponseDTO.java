package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public record ClienteResponseDTO(
        Long id,
        String email,
        String senha,
        String nome,
        String sobrenome,

        @JsonIgnore
        String cpf,

        @JsonIgnore
        String cep,

        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate dataNascimento
    ) {

    @JsonGetter("cpf")
    public String getCpfFormatado() {
        if(cpf == null || cpf.length() != 11) return cpf;
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    @JsonGetter("cep")
    public String getCepFormatado() {
        if(cep == null || cep.length() != 8) return cep;
        return cep.replaceAll("(\\d{5})(\\d{3})", "$1-$2");
    }
}
