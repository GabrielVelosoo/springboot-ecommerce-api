package io.github.gabrielvelosoo.ecommerceapi.dominio.service.auth;

public interface IdentidadeService {

    String criarUsuario(String email, String senha, String nome, String sobrenome);
    void atribuirRole(String usuarioId, String role);
}
