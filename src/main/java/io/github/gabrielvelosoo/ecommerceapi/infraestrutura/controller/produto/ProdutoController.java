package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.controller.produto;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.produto.ProdutoUseCase;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.controller.GenericController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/produtos")
@RequiredArgsConstructor
public class ProdutoController implements GenericController {

    private final ProdutoUseCase produtoUseCase;

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> salvarProduto(@RequestBody @Valid ProdutoRequestDTO produtoDTO) {
        ProdutoResponseDTO produtoDTOResponse = produtoUseCase.salvarProduto(produtoDTO);
        URI location = gerarHeaderLocation(produtoDTOResponse.id());
        return ResponseEntity.created(location).body(produtoDTOResponse);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> obterProdutosPorNome(@RequestParam(value = "nome", required = false) String produtoNome) {
        List<ProdutoResponseDTO> produtosDTO = produtoUseCase.obterProdutosPorNome(produtoNome);
        return ResponseEntity.ok(produtosDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoResponseDTO> editarProduto(@PathVariable(name = "id") Long produtoId,
                                                            @RequestBody @Valid ProdutoRequestDTO produtoDTO
    ) {
        ProdutoResponseDTO produtoDTOResponse = produtoUseCase.editarProduto(produtoId, produtoDTO);
        return ResponseEntity.ok(produtoDTOResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable(name = "id") Long produtoId) {
        produtoUseCase.deletarProduto(produtoId);
        return ResponseEntity.noContent().build();
    }
}
