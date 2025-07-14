package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.configuration;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Role;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.usuario.RoleRepository;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.entity.OAuthClient;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.repository.OAuthClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    @Transactional
    CommandLineRunner initRoles(RoleRepository roleRepository) {
        return args -> {
            if(roleRepository.findByNome("ADMIN").isEmpty()) {
                roleRepository.save(new Role("ADMIN"));
            }
            if(roleRepository.findByNome("USER").isEmpty()) {
                roleRepository.save(new Role("USER"));
            }
        };
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
