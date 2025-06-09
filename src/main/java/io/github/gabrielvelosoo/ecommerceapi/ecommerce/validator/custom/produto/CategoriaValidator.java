package io.github.gabrielvelosoo.ecommerceapi.ecommerce.validator.custom.produto;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.produto.Categoria;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.produto.CategoriaRepository;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.excecoes.RegistroDuplicadoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CategoriaValidator {

    private final CategoriaRepository categoriaRepository;

    public void validar(Categoria categoria) {
        if(categoriaExiste(categoria)) {
            throw new RegistroDuplicadoException("Esta categoria já existe");
        }
    }

    private boolean categoriaExiste(Categoria categoria) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findByNome(categoria.getNome());
        if(categoria.getId() == null) {
            return categoriaOptional.isPresent();
        }
        return categoriaOptional
                .map(c -> !c.getId().equals(categoria.getId()))
                .orElse(false);
    }
}
