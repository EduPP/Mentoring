package com.globant.mentoring.cliente.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.globant.mentoring.cliente.exception.BadRequestException;
import com.globant.mentoring.cliente.exception.ServiceError;

@RestControllerAdvice
public class ClienteHandleError {
	
	@ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ServiceError badRequestExceptionHandler(BadRequestException e) {
       // logger.error(e.getSystemMessage(), e);
        return new ServiceError("Bad Request - Code Error = 400", e.getMessage());
    }
	
}
