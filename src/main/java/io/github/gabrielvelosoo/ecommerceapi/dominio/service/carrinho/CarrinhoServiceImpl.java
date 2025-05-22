package io.github.gabrielvelosoo.ecommerceapi.dominio.service.carrinho;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.carrinho.Carrinho;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.carrinho.ItemCarrinho;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.carrinho.CarrinhoRepository;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.excecoes.RegistroNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CarrinhoServiceImpl implements CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;

    @Override
    public void salvarCarrinho(Carrinho carrinho) {
        carrinhoRepository.save(carrinho);
    }

    @Override
    public Carrinho obterCarrinhoPorId(Long carrinhoId) {
        return carrinhoRepository.findById(carrinhoId)
                .orElseThrow( () -> new RegistroNaoEncontradoException("Carrinho não encontrado"));
    }

    @Override
    public BigDecimal calcularValorCarrinho(Carrinho carrinho) {
        BigDecimal totalCarrinho = BigDecimal.ZERO;
        for(ItemCarrinho item : carrinho.getItens()) {
            BigDecimal precoUnitario = item.getPrecoUnitario();
            Integer quantidade = item.getQuantidade();
            BigDecimal totalItem = precoUnitario.multiply(BigDecimal.valueOf(quantidade));
            totalCarrinho = totalCarrinho.add(totalItem);
        }
        return totalCarrinho;
    }
}
