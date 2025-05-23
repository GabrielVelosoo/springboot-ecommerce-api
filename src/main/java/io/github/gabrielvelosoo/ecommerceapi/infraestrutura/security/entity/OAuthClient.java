package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

@Entity
@Table(name = "tb_oauth_client")
@Data
@EntityListeners(AuditingEntityListener.class)
public class OAuthClient implements Serializable {

    @Id
    @Column(name = "client_id", nullable = false, unique = true, length = 150)
    private String clientId;

    @Column(name = "client_secret", nullable = false, length = 400)
    private String clientSecret;

    @Column(name = "redirect_uri", nullable = false, length = 200)
    private String redirectUri;

    @Column(length = 50)
    private String scope;
}
