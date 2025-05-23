package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.repository;

import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.entity.OAuthClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OAuthClientRepository extends JpaRepository<OAuthClient, String> {
}
