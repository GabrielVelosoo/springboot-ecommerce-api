package io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.carrinho;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.carrinho.Carrinho;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.carrinho.CarrinhoResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarrinhoMapper {

    CarrinhoResponseDTO toDTO(Carrinho carrinho);
}
