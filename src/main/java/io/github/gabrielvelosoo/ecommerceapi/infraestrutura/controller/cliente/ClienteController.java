package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.controller.cliente;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.ClienteResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.usuario.UsuarioResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.cliente.ClienteUseCase;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.groups.OrdemValidacao;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.controller.GenericController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/clientes")
@RequiredArgsConstructor
public class ClienteController implements GenericController {

    private final ClienteUseCase clienteUseCase;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> salvarCliente(@RequestBody @Validated(OrdemValidacao.class) ClienteRequestDTO clienteDTO) {
        ClienteResponseDTO clienteDTOResponse = clienteUseCase.salvarCliente(clienteDTO);
        URI location = gerarHeaderLocation(clienteDTOResponse.id());
        return ResponseEntity.created(location).body(clienteDTOResponse);
    }

    @GetMapping(value = "/{clienteId}")
    public ResponseEntity<ClienteResponseDTO> obterClientePorId(@PathVariable(name = "clienteId") Long clienteId) {
        ClienteResponseDTO clienteDTOResponse = clienteUseCase.obterClientePorId(clienteId);
        return ResponseEntity.ok(clienteDTOResponse);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteResponseDTO> editarCliente(@PathVariable(name = "id") Long clienteId,
                                                            @RequestBody @Valid ClienteRequestDTO clienteDTO
    ) {
        ClienteResponseDTO clienteDTOResponse = clienteUseCase.editarCliente(clienteId, clienteDTO);
        return ResponseEntity.ok(clienteDTOResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable(name = "id") Long clienteId) {
        clienteUseCase.deletarCliente(clienteId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/me")
    public ResponseEntity<UsuarioResponseDTO> obterUsuarioLogado() {
        UsuarioResponseDTO usuarioDTO = clienteUseCase.obterUsuarioLogado();
        return ResponseEntity.ok(usuarioDTO);
    }
}
