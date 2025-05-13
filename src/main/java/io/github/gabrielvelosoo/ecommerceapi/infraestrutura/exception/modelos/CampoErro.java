package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CampoErro {

    private String campo;
    private String mensagem;
}
