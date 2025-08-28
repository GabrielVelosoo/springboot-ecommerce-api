package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.kafka.producer;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.event.PedidoCriadoEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoProducer {

    private static final String TOPICO = "pedidos-criados";
    private final KafkaTemplate<String, PedidoCriadoEvent> kafkaTemplate;

    public void publicarPedidoCriado(PedidoCriadoEvent event) {
        kafkaTemplate.send(TOPICO, event);
    }
}
