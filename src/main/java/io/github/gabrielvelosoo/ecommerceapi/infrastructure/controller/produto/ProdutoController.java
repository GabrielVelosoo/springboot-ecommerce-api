package io.github.gabrielvelosoo.ecommerceapi.infrastructure.controller.produto;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.produto.ProdutoUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoUseCase useCase;

    @PostMapping
    public ResponseEntity<Void> salvarProduto(@RequestBody @Valid ProdutoRequestDTO produtoDTO) {
        useCase.salvarProduto(produtoDTO);
        return ResponseEntity.ok().build();
    }
}
