package io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.produto;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.produto.Categoria;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.CategoriaRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.CategoriaResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    Categoria toEntity(CategoriaRequestDTO categoriaDTO);
    List<CategoriaResponseDTO> toDTOs(List<Categoria> categorias);
}
