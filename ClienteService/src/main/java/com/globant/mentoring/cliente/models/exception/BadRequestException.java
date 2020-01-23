package com.globant.mentoring.cliente.models.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BadRequestException extends BaseException{

	private String errorMessage;
	private String codeError;
}
