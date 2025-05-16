package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.controller.carrinho;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.carrinho.CarrinhoResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.carrinho.ItemCarrinhoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.carrinho.CarrinhoUseCase;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.controller.GenericController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;

@RestController
@RequestMapping(value = "/api/carrinhos")
@RequiredArgsConstructor
public class CarrinhoController implements GenericController {

    private final CarrinhoUseCase carrinhoUseCase;

    @GetMapping(value = "/{carrinhoId}")
    public ResponseEntity<CarrinhoResponseDTO> obterCarrinhoPorId(@PathVariable(name = "carrinhoId") Long carrinhoId) {
        CarrinhoResponseDTO carrinhoDTOResponse = carrinhoUseCase.obterCarrinhoPorId(carrinhoId);
        return ResponseEntity.ok(carrinhoDTOResponse);
    }

    @PostMapping(value = "/{carrinhoId}/produtos")
    public ResponseEntity<Void> adicionarProdutoAoCarrinho(@PathVariable(name = "carrinhoId") Long carrinhoId,
                                                           @RequestBody ItemCarrinhoRequestDTO itemCarrinhoDTO
    ) {
        carrinhoUseCase.adicionarProdutoAoCarrinho(carrinhoId, itemCarrinhoDTO.produtoId(), itemCarrinhoDTO.quantidade());
        URI location = gerarHeaderLocation(carrinhoId);
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{carrinhoId}/produtos/{produtoId}/diminuir")
    public ResponseEntity<Void> diminuirQuantidadeProdutoDoCarrinho(@PathVariable(name = "carrinhoId") Long carrinhoId,
                                                                    @PathVariable(name = "produtoId") Long produtoId
    ) {
        carrinhoUseCase.diminuirQuantidadeProdutoDoCarrinho(carrinhoId, produtoId);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{carrinhoId}/produtos/{produtoId}/adicionar")
    public ResponseEntity<Void> adicionarQuantidadeProdutoDoCarrinho(@PathVariable(name = "carrinhoId") Long carrinhoId,
                                                                    @PathVariable(name = "produtoId") Long produtoId
    ) {
        carrinhoUseCase.adicionarQuantidadeProdutoDoCarrinho(carrinhoId, produtoId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{carrinhoId}/produtos/{produtoId}")
    public ResponseEntity<Void> removerProdutoDoCarrinho(@PathVariable(name = "carrinhoId") Long carrinhoId,
                                                         @PathVariable(name = "produtoId") Long produtoId
    ) {
        carrinhoUseCase.removerProdutoDoCarrinho(carrinhoId, produtoId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{carrinhoId}/total")
    public ResponseEntity<BigDecimal> obterValorCarrinho(@PathVariable(name = "carrinhoId") Long carrinhoId) {
        BigDecimal totalCarrinho = carrinhoUseCase.obterValorCarrinho(carrinhoId);
        return ResponseEntity.ok(totalCarrinho);
    }
}
