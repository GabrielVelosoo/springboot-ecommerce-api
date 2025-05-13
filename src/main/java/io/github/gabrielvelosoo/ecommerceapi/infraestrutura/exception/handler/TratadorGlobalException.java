package io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.handler;

import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.excecoes.RegistroDuplicadoException;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.excecoes.RegistroNaoEncontradoException;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.excecoes.RegraNegocioException;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.modelos.CampoErro;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.modelos.ErroResponse;
import io.github.gabrielvelosoo.ecommerceapi.infraestrutura.exception.modelos.ErroValidacaoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class TratadorGlobalException {

    public TratadorGlobalException() {
    }

    @ExceptionHandler(RegistroDuplicadoException.class)
    public ResponseEntity<ErroResponse> handleRegistroDuplicadoException(RegistroDuplicadoException e) {
        int status = HttpStatus.CONFLICT.value();
        String mensagem = e.getMessage();
        LocalDateTime timestamp = LocalDateTime.now();
        ErroResponse erroResponse = new ErroResponse(
                status,
                mensagem,
                timestamp
        );
        return ResponseEntity.status(status).body(erroResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroValidacaoResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        int status = HttpStatus.UNPROCESSABLE_ENTITY.value();
        LocalDateTime timestamp = LocalDateTime.now();
        List<CampoErro> erros = e.getBindingResult().getFieldErrors()
                .stream()
                .map(erro -> new CampoErro(erro.getField(), erro.getDefaultMessage()))
                .toList();
        ErroValidacaoResponse erroResponse = new ErroValidacaoResponse(status, timestamp, erros);
        return ResponseEntity.status(status).body(erroResponse);
    }

    @ExceptionHandler(RegistroNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> handleRegistroNaoEncontradoException(RegistroNaoEncontradoException e) {
        int status = HttpStatus.NOT_FOUND.value();
        String mensagem = e.getMessage();
        LocalDateTime timestamp = LocalDateTime.now();
        ErroResponse erroResponse = new ErroResponse(
                status,
                mensagem,
                timestamp
        );
        return ResponseEntity.status(status).body(erroResponse);
    }

    @ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<ErroResponse> handleRegraNegocioException(RegraNegocioException e) {
        int status = HttpStatus.BAD_REQUEST.value();
        String mensagem = e.getMessage();
        LocalDateTime timestamp = LocalDateTime.now();
        ErroResponse erroResponse = new ErroResponse(
                status,
                mensagem,
                timestamp
        );
        return ResponseEntity.status(status).body(erroResponse);
    }
}
