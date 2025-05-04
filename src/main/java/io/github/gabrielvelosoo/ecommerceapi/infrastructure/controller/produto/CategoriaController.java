package io.github.gabrielvelosoo.ecommerceapi.infrastructure.controller.produto;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.CategoriaRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.CategoriaResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.produto.CategoriaUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaUseCase useCase;

    @PostMapping
    public ResponseEntity<Void> salvarCategoria(@RequestBody @Valid CategoriaRequestDTO categoriaDTO) {
        useCase.salvarCategoria(categoriaDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> obterCategorias() {
        List<CategoriaResponseDTO> categoriasDTO = useCase.obterCategorias();
        return ResponseEntity.ok(categoriasDTO);
    }
}
