package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.configuration;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.produto.Categoria;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.produto.CategoriaRepository;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.configuration.service.InitializationService;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.entity.OAuthClient;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.repository.OAuthClientRepository;
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

    private final InitializationService initializationService;

    @Bean
    @Transactional
    CommandLineRunner initRolesAndAdminUser() {
        return args -> initializationService.initRolesAndAdminUser();
    }

    @Bean
    @Transactional
    CommandLineRunner initClient(OAuthClientRepository clientRepository) {
        return args -> {
            String clientId = "meu-client";
            if(clientRepository.findByClientId(clientId).isEmpty()) {
                OAuthClient client = new OAuthClient();
                client.setClientId(clientId);
                client.setClientSecret(null);
                client.setRedirectUri("http://localhost:4200/auth/oauth2-callback");
                client.setScope("USER");
                clientRepository.save(client);
            }
        };
    }

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
