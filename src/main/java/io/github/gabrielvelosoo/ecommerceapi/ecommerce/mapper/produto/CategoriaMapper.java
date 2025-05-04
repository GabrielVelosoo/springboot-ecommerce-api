package io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.produto;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.produto.Categoria;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.CategoriaRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    Categoria toEntity(CategoriaRequestDTO categoriaDTO);
}
