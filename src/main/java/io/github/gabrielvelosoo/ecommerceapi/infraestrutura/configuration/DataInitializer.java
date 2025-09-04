package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.configuration;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.produto.Categoria;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.produto.CategoriaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    @Bean
    @Transactional
    CommandLineRunner initCategoriasPai(CategoriaRepository categoriaRepository) {
        return args -> {
            Map<String, List<String>> estrutura = new HashMap<>();
            estrutura.put("Roupas", List.of("Masculinas", "Femininas", "Infantis"));
            estrutura.put("Calçados", List.of("Esportivos", "Casuais"));
            estrutura.put("Acessórios", List.of("Relógios", "Óculos"));
            estrutura.put("Ofertas", List.of("Promoções de Verão", "Queima de Estoque"));
            for(Map.Entry<String, List<String>> entry : estrutura.entrySet()) {
                String nomePai = entry.getKey();
                List<String> filhos = entry.getValue();
                Categoria categoriaPai = categoriaRepository.findByNome(nomePai)
                        .orElseGet(() -> categoriaRepository.save(new Categoria(nomePai)));
                for(String nomeFilho : filhos) {
                    boolean existe = categoriaRepository
                            .findByNomeAndCategoriaPai(nomeFilho, categoriaPai)
                            .isPresent();
                    if(!existe) {
                        categoriaRepository.save(new Categoria(nomeFilho, categoriaPai));
                    }
                }
            }
        };
    }
}
