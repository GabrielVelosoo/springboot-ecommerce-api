package io.github.gabrielvelosoo.ecommerceapi.dominio.service.produto;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.produto.Produto;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.produto.ProdutoRepository;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.excecoes.RegistroNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
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
    public Produto obterProdutoPorId(Long produtoId) {
        return produtoRepository.findById(produtoId)
                .orElseThrow( () -> new RegistroNaoEncontradoException("Produto não encontrado") );
    }

    @Override
    public List<Produto> obterProdutosPorNome(Specification<Produto> spec) {
        return produtoRepository.findAll(spec);
    }

    @Override
    public Produto editarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void deletarProduto(Produto produto) {
        produtoRepository.delete(produto);
    }
}
