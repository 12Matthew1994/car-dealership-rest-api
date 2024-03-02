package org.example.controller.advice;


import org.example.service.exception.DuplicateEmailException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DuplicateEmailExceptionAdvice {

    @ExceptionHandler({DuplicateEmailException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleEntityNotFoundException(){

    }
}
