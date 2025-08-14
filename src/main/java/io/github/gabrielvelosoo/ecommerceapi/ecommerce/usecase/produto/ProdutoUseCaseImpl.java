package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.produto;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.produto.Produto;
import io.github.gabrielvelosoo.ecommerceapi.dominio.service.produto.ProdutoService;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.produto.ProdutoMapper;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.custom.produto.ProdutoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import static io.github.gabrielvelosoo.ecommerceapi.dominio.repository.produto.spec.ProdutoSpecification.*;

@Service
@RequiredArgsConstructor
public class ProdutoUseCaseImpl implements ProdutoUseCase {

    private final ProdutoService produtoService;
    private final ProdutoMapper produtoMapper;
    private final ProdutoValidator produtoValidator;

    @Override
    public ProdutoResponseDTO salvarProduto(ProdutoRequestDTO produtoDTO) throws IOException {
        MultipartFile imagem = produtoDTO.imagem();
        String uploadDir = "uploads/";
        String nomeArquivo = UUID.randomUUID() + "_" + imagem.getOriginalFilename();
        Path caminho = Paths.get(uploadDir + nomeArquivo);
        Files.createDirectories(caminho.getParent());
        Files.copy(imagem.getInputStream(), caminho, StandardCopyOption.REPLACE_EXISTING);

        Produto produto = produtoMapper.toEntity(produtoDTO);
        produto.setImagemUrl("/uploads/" + nomeArquivo);
        produtoValidator.validar(produto);
        Produto produtoSalvo = produtoService.salvaProduto(produto);
        return produtoMapper.toDTO(produtoSalvo);
    }

    @Override
    public List<ProdutoResponseDTO> obterProdutosPorNome(String produtoNome) {
        Specification<Produto> spec = Specification.where(filtrarPorNome(produtoNome));
        List<Produto> produtos = produtoService.obterProdutosPorNome(spec);
        return produtoMapper.toDTOs(produtos);
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
