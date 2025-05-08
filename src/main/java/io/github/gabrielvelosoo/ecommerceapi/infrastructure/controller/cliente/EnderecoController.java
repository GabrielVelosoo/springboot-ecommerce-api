package io.github.gabrielvelosoo.ecommerceapi.infrastructure.controller.cliente;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.EnderecoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.EnderecoResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.cliente.EnderecoUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoUseCase enderecoUseCase;

    @PostMapping
    public ResponseEntity<Void> salvarEndereco(@RequestBody @Valid EnderecoRequestDTO enderecoDTO) {
        enderecoUseCase.salvarEndereco(enderecoDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<EnderecoResponseDTO>> obterEnderecosClienteId(@PathVariable(name = "id") Long clienteId) {
        List<EnderecoResponseDTO> enderecosDTO = enderecoUseCase.obterEnderecosClienteId(clienteId);
        return ResponseEntity.ok().body(enderecosDTO);
    }
}
