package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.produto;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.produto.Produto;
import io.github.gabrielvelosoo.ecommerceapi.domain.service.produto.ProdutoService;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.produto.ProdutoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoUseCaseImpl implements ProdutoUseCase {

    private final ProdutoService service;
    private final ProdutoMapper produtoMapper;

    @Override
    public void salvarProduto(ProdutoRequestDTO produtoDTO) {
        Produto produto = produtoMapper.toEntity(produtoDTO);
        service.salvaProduto(produto);
    }

    @Override
    public List<ProdutoResponseDTO> obterProdutos() {
        List<Produto> produtos = service.obterProdutos();
        return produtoMapper.toDTOs(produtos);
    }
}
