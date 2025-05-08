package io.github.gabrielvelosoo.ecommerceapi.domain.service.produto;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.produto.Categoria;
import io.github.gabrielvelosoo.ecommerceapi.domain.repository.produto.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public void salvarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> obterCategorias() {
        return categoriaRepository.findAll();
    }
}
