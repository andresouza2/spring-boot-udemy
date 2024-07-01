package com.projectspring.aula.application.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    private MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource message) {
        this.messageSource = message;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<ErrorMessageDto>> handleValidationExceptions(MethodArgumentNotValidException e) {
        List<ErrorMessageDto> dto = new ArrayList<>();

        e.getBindingResult().getFieldErrors().forEach(err -> {
            String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());
            ErrorMessageDto error = new ErrorMessageDto(message, err.getField());
            dto.add(error);
        });

        return new ResponseEntity<List<ErrorMessageDto>>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClienteExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ClienteExceptionDTO> handleValidationExceptionsRuntimeException(ClienteExistsException e) {

        String message = messageSource.getMessage((MessageSourceResolvable) e, LocaleContextHolder.getLocale());
        ClienteExceptionDTO error = new ClienteExceptionDTO(message);

        return new ResponseEntity<ClienteExceptionDTO>(error, HttpStatus.BAD_REQUEST);
    }
}
