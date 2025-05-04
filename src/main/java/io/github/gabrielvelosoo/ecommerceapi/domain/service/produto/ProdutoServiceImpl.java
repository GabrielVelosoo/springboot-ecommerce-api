package io.github.gabrielvelosoo.ecommerceapi.domain.service.produto;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.produto.Produto;
import io.github.gabrielvelosoo.ecommerceapi.domain.repository.produto.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;

    @Override
    public void salvaProduto(Produto produto) {
        repository.save(produto);
    }

    @Override
    public List<Produto> obterProdutos() {
        return repository.findAll();
    }
}
