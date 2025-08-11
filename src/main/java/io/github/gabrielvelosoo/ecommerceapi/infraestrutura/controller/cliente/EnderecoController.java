package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.controller.cliente;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.EnderecoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.cliente.EnderecoResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.cliente.EnderecoUseCase;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.groups.OrdemValidacao;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.controller.GenericController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/enderecos")
@RequiredArgsConstructor
public class EnderecoController implements GenericController {

    private final EnderecoUseCase enderecoUseCase;

    @PostMapping
    public ResponseEntity<EnderecoResponseDTO> salvarEndereco(@RequestBody @Validated(OrdemValidacao.class) EnderecoRequestDTO enderecoDTO) {
        EnderecoResponseDTO enderecoDTOResponse = enderecoUseCase.salvarEndereco(enderecoDTO);
        URI location = gerarHeaderLocation(enderecoDTOResponse.id());
        return ResponseEntity.created(location).body(enderecoDTOResponse);
    }

    @GetMapping
    public ResponseEntity<List<EnderecoResponseDTO>> obterEnderecosUsuarioLogado() {
        List<EnderecoResponseDTO> enderecosDTO = enderecoUseCase.obterEnderecosUsuarioLogado();
        return ResponseEntity.ok(enderecosDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EnderecoResponseDTO> editarEndereco(@PathVariable(name = "id") Long enderecoId,
                                                              @RequestBody @Valid EnderecoRequestDTO enderecoDTO
    ) {
        EnderecoResponseDTO enderecoDTOResponse = enderecoUseCase.editarEndereco(enderecoId, enderecoDTO);
        return ResponseEntity.ok(enderecoDTOResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable(name = "id") Long enderecoId) {
        enderecoUseCase.deletarEndereco(enderecoId);
        return ResponseEntity.noContent().build();
    }
}
