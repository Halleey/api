package com.api.loja.exceptions;

public class IdException extends  RuntimeException {

    public IdException(Long id) {
        super("Produto não encontrado, id: " + id);
    }
}
