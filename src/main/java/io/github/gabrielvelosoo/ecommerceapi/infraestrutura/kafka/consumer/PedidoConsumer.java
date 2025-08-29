package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.kafka.consumer;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.event.PedidoCriadoEvent;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.cliente.ClienteUseCase;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.dto.BrevoEmailRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.dto.EmailRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.mapper.EmailMapper;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.service.EmailService;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.excecoes.RegistroNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoConsumer {

    private final EmailService emailService;
    private final ClienteUseCase clienteUseCase;
    private final EmailMapper emailMapper;

    @KafkaListener(topics = "pedidos-criados", groupId = "email-group", containerFactory = "kafkaListenerContainerFactory")
    public void consumir(PedidoCriadoEvent event) {
        System.out.println("Mensagem recebida do Kafka: " + event.pedidoId());
        try {
            ClienteResponseDTO clienteDTO = clienteUseCase.obterClientePorId(event.clienteId());
            EmailRequestDTO emailDTO = new EmailRequestDTO(
                    null,
                    null,
                    List.of(clienteDTO.email()),
                    "Seu pedido foi criado!",
                    "<p>Olá " + clienteDTO.nome() + "! Seu pedido #" + event.pedidoId() + " foi criado com sucesso.</p>"
            );
            BrevoEmailRequestDTO brevoDTO = emailMapper.toBrevoRequestWithDefaults(emailDTO);
            emailService.enviarEmail(brevoDTO)
                    .subscribe(
                            resp -> System.out.println("E-mail enviado com sucesso: " + resp),
                            err -> System.err.println("Erro ao enviar e-mail: " + err.getMessage())
                    );
        } catch(RegistroNaoEncontradoException e) {
            System.err.println("Cliente não encontrado para o pedido: " + event.pedidoId());
        } catch(Exception e) {
            System.err.println("Erro ao processar PedidoCriadoEvent: " + e.getMessage());
        }
    }
}
