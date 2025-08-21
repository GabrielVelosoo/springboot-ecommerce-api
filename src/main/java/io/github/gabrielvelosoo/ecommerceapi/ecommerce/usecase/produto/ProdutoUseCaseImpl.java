package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.produto;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.produto.Produto;
import io.github.gabrielvelosoo.ecommerceapi.dominio.service.file.FileService;
import io.github.gabrielvelosoo.ecommerceapi.dominio.service.produto.ProdutoService;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.produto.ProdutoMapper;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.custom.produto.ProdutoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static io.github.gabrielvelosoo.ecommerceapi.dominio.repository.produto.spec.ProdutoSpecification.*;

@Service
@RequiredArgsConstructor
public class ProdutoUseCaseImpl implements ProdutoUseCase {

    private final ProdutoService produtoService;
    private final FileService fileService;
    private final ProdutoMapper produtoMapper;
    private final ProdutoValidator produtoValidator;

    @Override
    public ProdutoResponseDTO salvarProduto(ProdutoRequestDTO produtoDTO) throws IOException {
        produtoValidator.validar(produtoMapper.toEntity(produtoDTO));
        String imagemUrl = fileService.salvarArquivo(produtoDTO.imagem());
        Produto produto = produtoMapper.toEntity(produtoDTO);
        produto.setImagemUrl(imagemUrl);
        Produto produtoSalvo = produtoService.salvaProduto(produto);
        return produtoMapper.toDTO(produtoSalvo);
    }

    @Override
    public Page<ProdutoResponseDTO> obterProdutosPorNome(String produtoNome, Integer pagina, Integer tamanhaPagina) {
        Specification<Produto> spec = Specification.where(filtrarPorNome(produtoNome));
        Pageable paginacao = paginacaoProduto(pagina, tamanhaPagina);
        Page<Produto> produtos = produtoService.obterProdutosPorNome(spec, paginacao);
        return produtos.map(produtoMapper::toDTO);
    }

    private Pageable paginacaoProduto(Integer pagina, Integer tamanhoPagina) {
        return PageRequest.of(pagina, tamanhoPagina);
    }

    @Override
    public List<ProdutoResponseDTO> obterProdutosPorCategoria(Long categoriaId) {
        List<Produto> produtos = produtoService.obterProdutosPorCategoria(categoriaId);
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
