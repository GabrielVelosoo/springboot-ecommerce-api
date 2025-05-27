package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.security.controller;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.oauth.OAuthClientRequestDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.oauth.OAuthClientResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.oauth.OAuthClientUseCase;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.controller.GenericController;
import jakarta.validation.Valid;
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
    public ResponseEntity<OAuthClientResponseDTO> salvarClient(@RequestBody @Valid OAuthClientRequestDTO oauthClientDTO) {
        OAuthClientResponseDTO oauthClientDTOResponse = oauthClientUseCase.salvarClient(oauthClientDTO);
        URI location = gerarHeaderLocation(oauthClientDTOResponse.id());
        return ResponseEntity.created(location).body(oauthClientDTOResponse);
    }

    @GetMapping(value = "/{clientId}")
    public ResponseEntity<OAuthClientResponseDTO> obterPorClientId(@PathVariable(name = "clientId") String clientId) {
        OAuthClientResponseDTO oauthClientDTO = oauthClientUseCase.obterPorClientId(clientId);
        return ResponseEntity.ok(oauthClientDTO);
    }
}
