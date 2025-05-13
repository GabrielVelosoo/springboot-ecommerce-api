package io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.produto;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.produto.Produto;
import io.github.gabrielvelosoo.ecommerceapi.domain.repository.produto.CategoriaRepository;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = CategoriaMapper.class)
public abstract class ProdutoMapper {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Mapping(target = "categoria", expression = "java( categoriaRepository.findById(produtoDTO.categoriaId()).orElse(null) )")
    public abstract Produto toEntity(ProdutoRequestDTO produtoDTO);

    public abstract ProdutoResponseDTO toDTO(Produto produto);
    public abstract List<ProdutoResponseDTO> toDTOs(List<Produto> produtos);
}
