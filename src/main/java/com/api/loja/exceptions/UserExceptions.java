package com.api.loja.exceptions;

public class UserExceptions extends RuntimeException {

    public UserExceptions(Long id) {
        super("Usuário não localizado");
    }
}
