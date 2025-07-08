package io.github.gabrielvelosoo.ecommerceapi.dominio.service.produto;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.produto.Categoria;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.produto.CategoriaRepository;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.excecoes.RegistroNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public Categoria salvarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> obterCategoriasRaizes() {
        List<Categoria> categoriasRaiz = categoriaRepository.findByCategoriaPaiIsNull();
        categoriasRaiz.forEach(this::carregarSubcategorias);
        return categoriasRaiz;
    }

    private void carregarSubcategorias(Categoria categoria) {
        categoria.getSubcategorias().forEach(this::carregarSubcategorias);
    }

    @Override
    public Categoria obterCategoriaPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow( () -> new RegistroNaoEncontradoException("Categoria não encontrada"));
    }
}
