package io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.produto;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.produto.Categoria;
import io.github.gabrielvelosoo.ecommerceapi.dominio.service.produto.CategoriaService;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.CategoriaRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.produto.CategoriaResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.mapper.produto.CategoriaMapper;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.custom.produto.CategoriaValidator;
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
    public CategoriaResponseDTO salvarCategoria(CategoriaRequestDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.toEntity(categoriaDTO);
        if(categoriaDTO.categoriaPaiId() != null) {
            Categoria pai = categoriaService.obterCategoriaPorId(categoriaDTO.categoriaPaiId());
            categoria.setCategoriaPai(pai);
        }
        categoriaValidator.validar(categoria);
        Categoria categoriaSalva = categoriaService.salvarCategoria(categoria);
        return categoriaMapper.toDTO(categoriaSalva);
    }

    @Override
    public List<CategoriaResponseDTO> obterCategoriasRaizes() {
        List<Categoria> categorias = categoriaService.obterCategoriasRaizes();
        return categoriaMapper.toDTOs(categorias);
    }
}
