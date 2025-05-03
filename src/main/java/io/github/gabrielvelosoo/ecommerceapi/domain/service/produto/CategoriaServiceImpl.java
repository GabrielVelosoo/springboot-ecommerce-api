package io.github.gabrielvelosoo.ecommerceapi.domain.service.produto;

import io.github.gabrielvelosoo.ecommerceapi.domain.entity.Categoria;
import io.github.gabrielvelosoo.ecommerceapi.domain.repository.produto.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repository;

    @Override
    public void salvarCategoria(Categoria categoria) {
        repository.save(categoria);
    }
}
