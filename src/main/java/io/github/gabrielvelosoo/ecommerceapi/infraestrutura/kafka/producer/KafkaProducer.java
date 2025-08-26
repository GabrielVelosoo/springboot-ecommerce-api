package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void enviarEvento(String topico, String mensagem) {
        kafkaTemplate.send(topico, mensagem);
    }
}
