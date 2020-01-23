package com.globant.mentoring.consultacliente.models;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = -263359922099027272L;
	
	private long id;
	private String name;
	private Date from;
	private Date through;
	private String estado;
}
