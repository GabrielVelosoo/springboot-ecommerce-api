package io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.pedido;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.pedido.ItemPedido;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.pedido.ItemPedidoResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.produto.ProdutoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ProdutoMapper.class)
public interface ItemPedidoMapper {

    ItemPedidoResponseDTO toDTO(ItemPedido itemPedido);
}
