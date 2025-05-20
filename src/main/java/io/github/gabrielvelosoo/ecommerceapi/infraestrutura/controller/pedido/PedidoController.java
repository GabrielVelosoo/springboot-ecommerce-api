package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.controller.pedido;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido.PedidoCarrinhoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido.PedidoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido.PedidoResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.pedido.PedidoUseCase;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.controller.GenericController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/pedidos")
@RequiredArgsConstructor
public class PedidoController implements GenericController {

    private final PedidoUseCase pedidoUseCase;

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> criarPedido(@RequestBody @Valid PedidoRequestDTO pedidoDTO) {
        PedidoResponseDTO pedidoResponseDTO = pedidoUseCase.criarPedido(pedidoDTO);
        URI location = gerarHeaderLocation(pedidoResponseDTO.id());
        return ResponseEntity.created(location).body(pedidoResponseDTO);
    }

    @PostMapping(value = "/confirmar-carrinho")
    public ResponseEntity<PedidoResponseDTO> criarPedidoComCarrinho(@RequestBody @Valid PedidoCarrinhoRequestDTO pedidoCarrinhoDTO) {
        PedidoResponseDTO pedidoResponseDTO = pedidoUseCase.criarPedidoComCarrinho(pedidoCarrinhoDTO);
        URI location = gerarHeaderLocation(pedidoResponseDTO.id());
        return ResponseEntity.created(location).body(pedidoResponseDTO);
    }
}
