package io.github.gabrielvelosoo.ecommerceapi.dominio.service.auth;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.cliente.Cliente;
import io.github.gabrielvelosoo.ecommerceapi.dominio.service.cliente.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final ClienteService clienteService;

    public Cliente obterClienteLogado() {
        String keycloakUsuarioId = obterKeycloakUsuarioIdLogado();
        return clienteService.obterClientePorKeycloakUsuarioId(keycloakUsuarioId);
    }

    public String obterKeycloakUsuarioIdLogado() {
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return jwt.getSubject();
    }
}
