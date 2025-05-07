package io.github.gabrielvelosoo.ecommerceapi.infrastructure.exception.handler;

import io.github.gabrielvelosoo.ecommerceapi.infrastructure.exception.RegistroDuplicadoException;
import io.github.gabrielvelosoo.ecommerceapi.infrastructure.exception.model.ErroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TratadorGlobalException {

    @ExceptionHandler(RegistroDuplicadoException.class)
    public ResponseEntity<ErroResponse> handleRegistroDuplicadoException(RegistroDuplicadoException e) {
        ErroResponse erroResponse = new ErroResponse(
                HttpStatus.CONFLICT.value(),
                e.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(erroResponse);
    }
}
