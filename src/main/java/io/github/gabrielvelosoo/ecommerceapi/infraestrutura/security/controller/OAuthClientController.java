package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.controller;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.oauth.OAuthClientUseCase;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.controller.GenericController;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.entity.OAuthClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/oauth-clients")
@RequiredArgsConstructor
public class OAuthClientController implements GenericController {

    private final OAuthClientUseCase oauthClientUseCase;

    @PostMapping
    public ResponseEntity<OAuthClient> salvarClient(@RequestBody OAuthClient oauthClient) {
        OAuthClient clientSalvo = oauthClientUseCase.salvarClient(oauthClient);
        URI location = gerarHeaderLocation(clientSalvo.getClientId());
        return ResponseEntity.created(location).body(clientSalvo);
    }

    @GetMapping(value = "/{clientId}")
    public ResponseEntity<OAuthClient> obterPorClientId(@PathVariable(name = "clientId") String clientId) {
        OAuthClient client = oauthClientUseCase.obterPorClientId(clientId);
        return ResponseEntity.ok(client);
    }
}
