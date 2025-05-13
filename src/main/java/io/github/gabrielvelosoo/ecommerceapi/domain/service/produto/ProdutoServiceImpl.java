package io.github.gabrielvelosoo.ecommerceapi.domain.service.produto;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.produto.Produto;
import io.github.gabrielvelosoo.ecommerceapi.domain.repository.produto.ProdutoRepository;
import io.github.gabrielvelosoo.ecommerceapi.infrastructure.exception.excecoes.RegistroNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Override
    public Produto salvaProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> obterProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto obterProdutoPorId(Long produtoId) {
        return produtoRepository.findById(produtoId)
                .orElseThrow( () -> new RegistroNaoEncontradoException("Produto não encontrado") );
    }

    @Override
    public Produto editarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }
}
