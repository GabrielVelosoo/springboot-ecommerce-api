package io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.custom.produto;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.produto.Produto;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.produto.CategoriaRepository;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.excecoes.RegistroNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProdutoValidator {

    private final CategoriaRepository categoriaRepository;

    public void validar(Produto produto) {
        if(!categoriaExiste(produto)) {
            throw new RegistroNaoEncontradoException("Categoria não encontrada");
        }
    }

    public boolean categoriaExiste(Produto produto) {
        if(produto.getCategoria() == null || produto.getCategoria().getId() == null) {
            return false;
        }
        return categoriaRepository.existsById(produto.getCategoria().getId());
    }
}
