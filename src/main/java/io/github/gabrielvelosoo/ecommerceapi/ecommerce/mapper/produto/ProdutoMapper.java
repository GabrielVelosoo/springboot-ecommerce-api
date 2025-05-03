package io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.produto;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.Produto;
import io.github.gabrielvelosoo.ecommerceapi.domain.repository.produto.CategoriaRepository;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.ProdutoRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = CategoriaMapper.class)
public abstract class ProdutoMapper {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Mapping(target = "categoria", expression = "java( categoriaRepository.findById(produtoDTO.categoriaId()).orElse(null) )")
    public abstract Produto toEntity(ProdutoRequestDTO produtoDTO);
}
