package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.repository;

import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.entity.OAuthClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OAuthClientRepository extends JpaRepository<OAuthClient, String> {

    Optional<OAuthClient> findByClientId(String clientId);
}
