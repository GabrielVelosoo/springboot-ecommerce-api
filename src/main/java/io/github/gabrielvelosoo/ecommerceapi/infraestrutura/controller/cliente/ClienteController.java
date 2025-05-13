package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.controller.cliente;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.cliente.ClienteUseCase;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.controller.GenericController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteResponseDTO> editarCliente(@PathVariable(name = "id") Long clienteId,
                                                            @RequestBody @Valid ClienteRequestDTO clienteDTO
    ) {
        ClienteResponseDTO clienteDTOResponse = clienteUseCase.editarCliente(clienteId, clienteDTO);
        return ResponseEntity.ok().body(clienteDTOResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable(name = "id") Long clienteId) {
        clienteUseCase.deletarCliente(clienteId);
        return ResponseEntity.noContent().build();
    }
}
