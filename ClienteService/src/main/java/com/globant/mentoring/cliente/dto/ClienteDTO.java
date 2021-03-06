package com.globant.mentoring.cliente.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.globant.mentoring.cliente.entity.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 3198761307627880968L;

	private long id;
	private String name;
	private String userName;
	private Date from;
	private Date through;
	private String estado;
	private List<Role> roles;
	
}
