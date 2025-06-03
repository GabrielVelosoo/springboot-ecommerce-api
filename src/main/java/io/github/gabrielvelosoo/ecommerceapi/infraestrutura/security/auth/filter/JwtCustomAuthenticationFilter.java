package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.auth.filter;

import io.github.gabrielvelosoo.ecommerceapi.dominio.entity.usuario.Usuario;
import io.github.gabrielvelosoo.ecommerceapi.dominio.service.usuario.UsuarioService;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.auth.CustomAuthentication;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@SuppressWarnings("ALL")
@Component
@RequiredArgsConstructor
public class JwtCustomAuthenticationFilter extends OncePerRequestFilter {

    private final UsuarioService usuarioService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(deveConverterParaCustomAuthentication(auth)) {
            String email = auth.getName();
            Usuario usuario = usuarioService.obterUsuarioPorEmail(email);
            if(usuario != null) {
                auth = new CustomAuthentication(usuario);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(request, response);
    }

    private boolean deveConverterParaCustomAuthentication(Authentication auth) {
        return auth instanceof JwtAuthenticationToken;
    }
}
