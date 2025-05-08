package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.produto;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.produto.Categoria;
import io.github.gabrielvelosoo.ecommerceapi.domain.service.produto.CategoriaService;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.CategoriaRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.CategoriaResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.produto.CategoriaMapper;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.produto.CategoriaValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaUseCaseImpl implements CategoriaUseCase {

    private final CategoriaService categoriaService;
    private final CategoriaMapper categoriaMapper;
    private final CategoriaValidator categoriaValidator;

    @Override
    public void salvarCategoria(CategoriaRequestDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.toEntity(categoriaDTO);
        categoriaValidator.validar(categoria);
        categoriaService.salvarCategoria(categoria);
    }

    @Override
    public List<CategoriaResponseDTO> obterCategorias() {
        List<Categoria> categorias = categoriaService.obterCategorias();
        return categoriaMapper.toDTOs(categorias);
    }
}
