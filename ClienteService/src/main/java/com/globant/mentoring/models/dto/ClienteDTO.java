package com.globant.mentoring.models.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 3198761307627880968L;

	private long id;
	private String name;
	private Date from;
	private Date through;
	private String estado;
	
}
