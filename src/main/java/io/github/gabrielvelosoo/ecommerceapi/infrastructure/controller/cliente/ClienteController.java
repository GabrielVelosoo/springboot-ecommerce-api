package io.github.gabrielvelosoo.ecommerceapi.infrastructure.controller.cliente;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.cliente.ClienteUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteUseCase useCase;

    @PostMapping
    public ResponseEntity<Void> salvarCliente(@RequestBody @Valid ClienteRequestDTO clienteDTO) {
        useCase.salvarCliente(clienteDTO);
        return ResponseEntity.ok().build();
    }
}
