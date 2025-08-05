package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.controller.usuario;

import io.github.gabrielvelosoo.ecommerceapi.ecommerce.dto.usuario.AlterarSenhaDTO;
import io.github.gabrielvelosoo.ecommerceapi.ecommerce.usecase.usuario.UsuarioUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioUseCase usuarioUseCase;

    @PutMapping("/alterar-senha")
    public ResponseEntity<Void> alterarSenha(@RequestBody @Valid AlterarSenhaDTO senhasDTO) {
        usuarioUseCase.alterarSenha(senhasDTO);
        return ResponseEntity.noContent().build();
    }
}
