package com.globant.mentoring.cliente.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadRequestException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String errorMessage;
	private String codeError;
	
	public BadRequestException(String message) {
		super(message);
	}
}
