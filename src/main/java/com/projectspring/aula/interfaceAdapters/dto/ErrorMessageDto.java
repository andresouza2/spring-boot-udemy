package com.projectspring.aula.interfaceAdapters.dto;

public class ErrorMessageDto {

    private String message;
    private String field;

    public ErrorMessageDto(String message, String field) {
        this.message = message;
        this.field = field;
    }
}
