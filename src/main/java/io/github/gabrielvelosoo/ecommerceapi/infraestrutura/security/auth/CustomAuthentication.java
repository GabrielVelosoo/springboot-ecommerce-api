package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.auth;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.stream.Collectors;

public record CustomAuthentication(Usuario usuario) implements Authentication {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.usuario.getUsuarioRoles()
                .stream()
                .map(usuarioRole -> new SimpleGrantedAuthority(usuarioRole.getRole().getNome()))
                .collect(Collectors.toList());
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return usuario;
    }

    @Override
    public Object getPrincipal() {
        return usuario;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        throw new IllegalStateException("Don´t need call. Already authenticated");
    }

    @Override
    public String getName() {
        return usuario.getEmail();
    }
}
