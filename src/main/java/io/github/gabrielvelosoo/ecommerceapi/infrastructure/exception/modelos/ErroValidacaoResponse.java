package io.github.gabrielvelosoo.ecommerceapi.infrastructure.exception.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class ErroValidacaoResponse {

    private Integer status;
    private LocalDateTime timestamp;
    private List<CampoErro> erros;
}
