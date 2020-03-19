package com.globant.app.oauth.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Cliente implements Serializable{

	private Long id;
	private String name;
	private String username;
	private String password;
	private Date from;
	private Date through;	
	private String estado;
	private List<Role> roles;
	
	private static final long serialVersionUID = 792594780988936534L;
	
}
