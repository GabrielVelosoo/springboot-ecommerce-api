package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.configuration;

import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.configuration.service.InitializationService;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.entity.OAuthClient;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.repository.OAuthClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
                client.setPostLogoutRedirectUri("http://localhost:4200/home");
                client.setScope("USER");

                clientRepository.save(client);
            }
        };
    }
}
