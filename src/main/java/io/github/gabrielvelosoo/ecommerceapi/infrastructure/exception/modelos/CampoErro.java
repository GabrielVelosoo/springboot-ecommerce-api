package io.github.gabrielvelosoo.ecommerceapi.infrastructure.exception.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CampoErro {

    private String campo;
    private String mensagem;
}
