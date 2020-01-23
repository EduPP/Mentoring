package com.globant.mentoring.cliente.models.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends Exception {

	private String systemMessage;
	private String moreInfo;
	
}
