package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.produto;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.produto.Produto;
import io.github.gabrielvelosoo.ecommerceapi.domain.service.produto.ProdutoService;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.produto.ProdutoMapper;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.produto.ProdutoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoUseCaseImpl implements ProdutoUseCase {

    private final ProdutoService produtoService;
    private final ProdutoMapper produtoMapper;
    private final ProdutoValidator produtoValidator;

    @Override
    public ProdutoResponseDTO salvarProduto(ProdutoRequestDTO produtoDTO) {
        Produto produto = produtoMapper.toEntity(produtoDTO);
        produtoValidator.validar(produto);
        Produto produtoSalvo = produtoService.salvaProduto(produto);
        return produtoMapper.toDTO(produtoSalvo);
    }

    @Override
    public List<ProdutoResponseDTO> obterProdutos() {
        List<Produto> produtos = produtoService.obterProdutos();
        return produtoMapper.toDTOs(produtos);
    }

    @Override
    public ProdutoResponseDTO editarProduto(Long produtoId, ProdutoRequestDTO produtoDTO) {
        Produto produto = produtoService.obterProdutoPorId(produtoId);
        produtoValidator.validar(produto);
        produtoMapper.editarProduto(produto, produtoDTO);
        Produto produtoEditado = produtoService.editarProduto(produto);
        return produtoMapper.toDTO(produtoEditado);
    }

    @Override
    public void deletarProduto(Long produtoId) {
        Produto produto = produtoService.obterProdutoPorId(produtoId);
        produtoService.deletarProduto(produto);
    }
}
