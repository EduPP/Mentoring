package com.globant.mentoring.cliente.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ServiceError {
    private String developerMessage;
    private String userMessage;
}