package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.service;

import io.github.gabrielvelosoo.ecommerceapi.dominio.service.auth.IdentidadeService;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KeycloakUserService implements IdentidadeService {

    private final Keycloak keycloak;

    @Value("${keycloak.realm}")
    private String realm;

    @Override
    public String criarUsuario(String email, String senha, String nome, String sobrenome) {
        try {
            List<UserRepresentation> existente = keycloak.realm(realm).users().search(email, true);
            if (!existente.isEmpty()) {
                throw new RuntimeException("Usuário já existe no Keycloak: " + email);
            }
            UserRepresentation user = new UserRepresentation();
            user.setUsername(email);
            user.setEmail(email);
            user.setFirstName(nome);
            user.setLastName(sobrenome);
            user.setEnabled(true);
            Response response = keycloak.realm(realm).users().create(user);
            if(response.getStatus() != 201) {
                throw new RuntimeException("Erro ao criar usuário no Keycloak: " + response.getStatus());
            }
            String usuarioId = CreatedResponseUtil.getCreatedId(response);
            CredentialRepresentation cred = new CredentialRepresentation();
            cred.setTemporary(false);
            cred.setType(CredentialRepresentation.PASSWORD);
            cred.setValue(senha);
            keycloak.realm(realm).users().get(usuarioId).resetPassword(cred);
            atribuirRole(usuarioId, "USER");
            return usuarioId;
        } catch(Exception e) {
            throw new RuntimeException("Falha ao criar usuário no Keycloak: " + e.getMessage(), e);
        }
    }

    @Override
    public void atribuirRole(String usuarioId, String role) {
        try {
            RoleRepresentation userRole = keycloak.realm(realm).roles().get(role).toRepresentation();
            keycloak.realm(realm).users().get(usuarioId).roles().realmLevel().add(List.of(userRole));
        } catch(Exception e) {
            throw new RuntimeException("Falha ao atribuir role no Keycloak: " + e.getMessage(), e);
        }
    }
}
