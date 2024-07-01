package com.projectspring.aula.application.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * é fundamental passar os @Getters e @Setter e metodos contrutores desta classe
 * */

@Data
@AllArgsConstructor
public class ErrorMessageDto {

    private String message;
    private String field;

}
