package io.github.gabrielvelosoo.ecommerceapi.infrastructure.controller.cliente;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.cliente.ClienteUseCase;
import io.github.gabrielvelosoo.ecommerceapi.infrastructure.controller.GenericController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/clientes")
@RequiredArgsConstructor
public class ClienteController implements GenericController {

    private final ClienteUseCase clienteUseCase;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> salvarCliente(@RequestBody @Valid ClienteRequestDTO clienteDTO) {
        ClienteResponseDTO clienteDTOResponse = clienteUseCase.salvarCliente(clienteDTO);
        URI location = gerarHeaderLocation(clienteDTOResponse.id());
        return ResponseEntity.created(location).body(clienteDTOResponse);
    }
}
