package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.email.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "email.from")
@Getter
@Setter
public class EmailProperties {

    private String name;
    private String address;
}
