package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.kafka.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    @KafkaListener(topics = "pedidos", groupId = "default-group")
    public void consumir(String mensagem) {
        System.out.println("Mensagem recebida do Kafka: " + mensagem);
    }
}
