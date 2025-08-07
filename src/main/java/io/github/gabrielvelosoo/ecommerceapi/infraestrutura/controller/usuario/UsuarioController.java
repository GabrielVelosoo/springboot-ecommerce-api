package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.controller.usuario;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.usuario.AlterarSenhaDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.usuario.UsuarioResponseDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.usuario.UsuarioUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioUseCase usuarioUseCase;

    @GetMapping(value = "/me")
    public ResponseEntity<UsuarioResponseDTO> obterUsuarioLogado() {
        UsuarioResponseDTO usuarioDTO = usuarioUseCase.obterUsuarioLogado();
        return ResponseEntity.ok(usuarioDTO);
    }

    @PutMapping("/alterar-senha")
    public ResponseEntity<Void> alterarSenha(@RequestBody @Valid AlterarSenhaDTO senhasDTO) {
        usuarioUseCase.alterarSenha(senhasDTO);
        return ResponseEntity.noContent().build();
    }
}
