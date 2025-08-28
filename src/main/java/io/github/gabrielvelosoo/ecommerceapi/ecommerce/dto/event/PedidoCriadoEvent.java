package io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.event;

import java.time.Instant;

public record PedidoCriadoEvent(
        Long pedidoId,
        Long clienteId,
        Instant criadoEm,
        int version
    ) {
}
