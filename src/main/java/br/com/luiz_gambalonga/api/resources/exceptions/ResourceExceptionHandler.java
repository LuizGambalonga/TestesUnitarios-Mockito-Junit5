package br.com.luiz_gambalonga.api.resources.exceptions;

import br.com.luiz_gambalonga.api.services.exceptions.DataIntegrateViolationException;
import br.com.luiz_gambalonga.api.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ErrosPadrao> objetoNaoEncontrado(ObjectNotFoundException ex, HttpServletRequest request){
           ErrosPadrao erros = new ErrosPadrao(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getRequestURI());
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erros);
    }

    @ExceptionHandler(DataIntegrateViolationException.class)
    public ResponseEntity<ErrosPadrao> DataIntegrateViolationException (DataIntegrateViolationException ex, HttpServletRequest request){
        ErrosPadrao erros = new ErrosPadrao(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    }
}
