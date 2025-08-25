package io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.produto;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.produto.Categoria;
import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.produto.Produto;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.produto.CategoriaRepository;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.excecoes.RegistroNaoEncontradoException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = CategoriaMapper.class)
public abstract class ProdutoMapper {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Mapping(target = "categoria", expression = "java( categoriaRepository.findById(produtoDTO.categoriaId()).orElse(null) )")
    @Mapping(target = "imagemUrl", ignore = true)
    public abstract Produto toEntity(ProdutoRequestDTO produtoDTO);

    @Mapping(target = "categoriaPath", expression = "java(montarCategoriaPath(produto.getCategoria()))")
    public abstract ProdutoResponseDTO toDTO(Produto produto);
    public abstract List<ProdutoResponseDTO> toDTOs(List<Produto> produtos);

    public void editarProduto(Produto produto, ProdutoRequestDTO produtoDTO) {
        produto.setNome(produtoDTO.nome());
        produto.setDescricao(produtoDTO.descricao());
        produto.setPreco(produtoDTO.preco());
        produto.setQuantidadeEstoque(produtoDTO.quantidadeEstoque());
        produto.setCategoria(categoriaRepository.findById(produtoDTO.categoriaId()).orElseThrow( () -> new RegistroNaoEncontradoException("Categoria não encontrada") ));
    }

    public String montarCategoriaPath(Categoria categoria) {
        if(categoria == null) return "";
        if(categoria.getCategoriaPai() != null) {
            return categoria.getCategoriaPai().getNome() + " > " + categoria.getNome();
        }
        return categoria.getNome();
    }
}
