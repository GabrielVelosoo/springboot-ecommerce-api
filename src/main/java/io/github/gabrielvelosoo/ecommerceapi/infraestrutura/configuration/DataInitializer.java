package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.configuration;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Role;
import io.github.gabrielvelosoo.ecommerceapi.dominio.repository.usuario.RoleRepository;
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
}
