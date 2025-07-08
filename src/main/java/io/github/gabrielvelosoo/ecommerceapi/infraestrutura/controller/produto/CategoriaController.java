package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.controller.produto;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.CategoriaRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.CategoriaResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.produto.CategoriaUseCase;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.controller.GenericController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/categorias")
@RequiredArgsConstructor
public class CategoriaController implements GenericController {

    private final CategoriaUseCase categoriaUseCase;

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> salvarCategoria(@RequestBody @Valid CategoriaRequestDTO categoriaDTO) {
        CategoriaResponseDTO categoriaDTOResponse = categoriaUseCase.salvarCategoria(categoriaDTO);
        URI location = gerarHeaderLocation(categoriaDTOResponse.id());
        return ResponseEntity.created(location).body(categoriaDTOResponse);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> obterCategoriasRaizes() {
        List<CategoriaResponseDTO> categoriasDTO = categoriaUseCase.obterCategoriasRaizes();
        return ResponseEntity.ok(categoriasDTO);
    }
}
