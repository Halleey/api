package com.api.loja.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptions {
    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus( HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleNumberFormatException(NumberFormatException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID não é um número válido");
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno do servidor");
    }


}
