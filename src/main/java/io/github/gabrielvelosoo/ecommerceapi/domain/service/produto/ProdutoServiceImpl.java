package io.github.gabrielvelosoo.ecommerceapi.domain.service.produto;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.Produto;
import io.github.gabrielvelosoo.ecommerceapi.domain.repository.produto.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;

    @Override
    public void salvaProduto(Produto produto) {
        repository.save(produto);
    }
}
