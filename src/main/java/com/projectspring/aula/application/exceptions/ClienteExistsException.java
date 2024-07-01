package com.projectspring.aula.application.exceptions;

public class ClienteExistsException extends Exception{

    private String message;

    public ClienteExistsException() {
        super("já existe");
    }

    public ClienteExistsException(String message) {
        super(message);
    }
}
